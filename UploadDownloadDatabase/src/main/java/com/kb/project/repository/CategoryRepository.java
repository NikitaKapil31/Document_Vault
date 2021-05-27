package com.kb.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kb.project.model.Categories;


@Repository
public interface CategoryRepository  extends JpaRepository<Categories, Integer>{

	

}

