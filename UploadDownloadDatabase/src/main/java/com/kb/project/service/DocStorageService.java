package com.kb.project.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kb.project.model.Doc;
import com.kb.project.repository.DocRepository;

@Service
public class DocStorageService {
  @Autowired
  private DocRepository docRepository;
  
  public String saveFile(String title, String category, MultipartFile file) throws IOException {
	  String docname = file.getOriginalFilename();
//	  Doc doc = new Doc(docname,file.getContentType(),,category, file.getBytes());
	  Doc doc = new Doc();
	  doc.setDocName(docname);
	  doc.setDocType(file.getContentType());
	  doc.setTitle(title);
	  doc.setCategory(category);
	  doc.setData(file.getBytes());
	  
	  
	  if(doc==null) 
		return "Document not created";
	  else
		return "Employee created successfully";
	  
	 
  }
  public Optional<Doc> getFile(Integer fileId) {
	  return docRepository.findById(fileId);
  }
  public List<Doc> getFiles(){
	  return docRepository.findAll();
  }
}
