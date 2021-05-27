package com.kb.project.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kb.project.exception.InvalidDetailsException;
import com.kb.project.model.Doc;

public class CategoryContoller {

	@RestController
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path = "categories")
	public class CategoryController {
		
		
		//Create Doc
		@PostMapping(value="/saveCat")
		public Doc saveCategories(@RequestParam("file") MultipartFile file,
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
	}
}
