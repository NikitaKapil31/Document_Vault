package com.kb.project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kb.project.exception.InvalidDetailsException;
import com.kb.project.model.Doc;
import com.kb.project.model.Response;
import com.kb.project.service.DocService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "doc")
public class DocController {

	@Autowired 
	private DocService docStorageService;
		
	//Create Doc
	@PostMapping(value="/uploadFiles", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public Doc uploadMultipleFiles(@RequestParam("file") MultipartFile file,
    		@RequestParam("user") String user ) throws IOException, InvalidDetailsException {
			Doc doc = docStorageService.saveFile(file,user);
			if(doc!=null)
	    	{
	    		return doc;
	    	}
	    	else
	    	{
	    		throw new InvalidDetailsException("Document Not uploaded");
	    	}
	}
	
	@ExceptionHandler(InvalidDetailsException.class)
	public ResponseEntity<Response> usernotfound1(InvalidDetailsException e)
	{
		return new ResponseEntity<Response>( new Response(e.getMessage()),HttpStatus.OK);
	}

	//Get Particular Doc data
	@GetMapping("/getFile/{fileId}")
	public ResponseEntity<ByteArrayResource> getDocById(@PathVariable Integer fileId){
		Doc doc = docStorageService.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}
	
	//Get All Doc data
	@GetMapping("/getFiles")
	public ResponseEntity<List<Doc>> getDocs(){
//		System.out.println("in get con");
		List<Doc> doc = docStorageService.getFiles();
		return new ResponseEntity<List<Doc>>(doc,new HttpHeaders(),HttpStatus.OK);
	}
	
		
	//Deleting Doc data
	@DeleteMapping("/DeleteDoc/{id}")
	public ResponseEntity<String> delDoc(@PathVariable("id") int id) 
	{
		String message= docStorageService.deleteDoc(id);
		return new ResponseEntity<String>(message,new HttpHeaders(),HttpStatus.OK);
	}
	
	
}
