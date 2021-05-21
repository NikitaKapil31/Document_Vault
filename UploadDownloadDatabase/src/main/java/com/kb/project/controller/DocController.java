package com.kb.project.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kb.project.model.Doc;
import com.kb.project.service.DocStorageService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "doc")
public class DocController {

	@Autowired 
	private DocStorageService docStorageService;
		
	@PostMapping("/uploadFiles")
	public ResponseEntity<String> uploadMultipleFiles(@RequestParam("title") String title ,@RequestParam("category") String category, @RequestParam("file") MultipartFile file) throws IOException {
			System.out.println("in controller");
			String message = docStorageService.saveFile(title, category, file);
			return new ResponseEntity<String>(message, new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@GetMapping("/getFile/{fileId}")
	public ResponseEntity<Doc> getDocById(@PathVariable Integer fileId){
		Doc doc = docStorageService.getFile(fileId).get();
//		return ResponseEntity.ok()
//				.contentType(MediaType.parseMediaType(doc.getDocType()))
//				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
//				.body(new ByteArrayResource(doc.getData()));
		return new ResponseEntity<Doc>(doc,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/getFiles")
	public ResponseEntity<List<Doc>> getDocs(){
		System.out.println("in get con");
		List<Doc> doc = docStorageService.getFiles();
//		return ResponseEntity.ok()
//				.contentType(MediaType.parseMediaType(doc.getDocType()))
//				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
//				.body(new ByteArrayResource(doc.getData()));
		return new ResponseEntity<List<Doc>>(doc,new HttpHeaders(),HttpStatus.OK);
	}
	
}
