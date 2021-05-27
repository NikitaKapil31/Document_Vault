package com.kb.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Categories {

	@Entity
	@Table(name="categories")
	public class categories{
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String categories;
		public categories(Integer id, String categories) {
			super();
			this.id = id;
			this.categories = categories;
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCategories() {
			return categories;
		}
		public void setCategories(String categories) {
			this.categories = categories;
		}
	}
}
