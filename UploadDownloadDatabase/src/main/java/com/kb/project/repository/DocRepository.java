package com.kb.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kb.project.model.Doc;

@Repository
public interface DocRepository  extends JpaRepository<Doc,Integer>{

	

}
