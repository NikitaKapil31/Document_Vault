package com.kb.project.service;
import com.kb.project.model.Doc;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {
	
    Doc saveFile(MultipartFile file);
    
    Optional<Doc> getFile(Integer fileId);
    
    List<Doc> getFiles();
    
    Doc updateDoc(Doc doc);
    
    String deleteDoc(int id);
    
}