package com.ecommerce.products.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	private long id;
	
	private String title;
	
	private String imageUrl;
	
	@OneToMany(mappedBy="category")
	@JsonIgnore
	private List<Product> products;
	
	protected Category() {
		super();
		this.id = 0;
		this.title = "";
		this.imageUrl = "";
	}
	

	public Category(int id, String title, String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

}
