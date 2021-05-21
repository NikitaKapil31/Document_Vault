package com.kb.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	
	public Doc(String title, String category, byte[] data) {
		super();
		this.title = title;
		this.category = category;
		this.data = data;
	}

	@Lob
	private byte[] data;
	
	public Doc() {}

//	public Doc(String docName, String docType, byte[] data) {
//		super();
//		this.docName = docName;
//		this.docType = docType;
//		this.data = data;
//	}

	public Doc(String docName, String docType, String title, String category, byte[] data) {
		super();
		this.docName = docName;
		this.docType = docType;
		this.title = title;
		this.category = category;
		this.data = data;
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
