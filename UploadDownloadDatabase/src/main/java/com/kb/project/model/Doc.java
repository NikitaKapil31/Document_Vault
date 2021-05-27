package com.kb.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="docs")
public class Doc {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String docName;
	private String docType;
	private String title;
	private String category;
	
	@Column(name = "created_at")
	private Date createdAt;
	@Lob
	private byte[] data;
	
	
	@PrePersist
	  void createdAt() {
	    this.createdAt = new Date();
	  }
	

	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public Doc() {
		super();
	}

	public Doc(Integer id, String docName, String docType, String title, String category, byte[] data) {
		super();
		this.id = id;
		this.docName = docName;
		this.docType = docType;
		this.title = title;
		this.category = category;
		this.data = data;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
