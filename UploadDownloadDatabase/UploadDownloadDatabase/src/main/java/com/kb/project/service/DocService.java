package com.kb.project.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kb.project.model.Doc;
import com.kb.project.repository.DocRepository;

@Service
public class DocService {
  @Autowired
  private DocRepository docRepository;
  
  
  public Doc saveFile(MultipartFile file, String user) throws IOException {
	  Doc doc = new Doc();
	  
	  try {
			doc = new ObjectMapper().readValue(user, Doc.class);
		} catch (JsonMappingException e) {
					e.printStackTrace();
		} catch (JsonProcessingException e) {
				e.printStackTrace();
		} 
		try {
			doc.setData(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	  doc.setDocName(file.getOriginalFilename());
	  doc.setDocType(file.getContentType());
	  docRepository.save(doc); 
	  return doc;   //Save file
	 
  }
  public Optional<Doc> getFile(Integer fileId) {
	  return docRepository.findById(fileId); //To get particular document
  }
  public List<Doc> getFiles(){
	  return docRepository.findAll(); //To get list of documents
  }
    
  public String deleteDoc(int id) {
		docRepository.deleteById(id);
		return "Successfully Deleted!"; //Delete the document
	}
   
 
}
