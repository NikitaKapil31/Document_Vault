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
public class DocStorageService {
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
	  return doc;
	 
  }
  public Optional<Doc> getFile(Integer fileId) {
	  return docRepository.findById(fileId);
  }
  public List<Doc> getFiles(){
	  return docRepository.findAll();
  }
  
//  public Doc updateDoc(Doc doc) {
//	  docRepository.save(doc);
//	  Doc d = em.find(Doc.class, doc.getId());
//	  d.setTitle(doc.getTitle()); 
//	 return d;			
//	}
  
  public Doc updateDoc(MultipartFile file, String user) throws IOException {
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
	  return doc;
	 
  }
  
  public String deleteDoc(int id) {
		docRepository.deleteById(id);
		return "Successfully Deleted!";
	}
  
  public int countDoc() {
	  List<Doc> doc = docRepository.findAll();
	  return doc.size();
  }
}
