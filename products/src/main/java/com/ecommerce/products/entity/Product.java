package com.ecommerce.products.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Category category;
	
	private String title;
	
	private String description;
	
	private String imageUrl;
	
	private double price;
	
	private long quantity;
	
	private LocalDateTime created_at;
	
	private LocalDateTime updated_at;
	
	
	public Product() {
		super();
		this.id = 0;
		this.category = null;
		this.title = "";
		this.description = "";
		this.imageUrl = "";
		this.price = 0.00;
		this.quantity = 0;
		this.created_at = LocalDateTime.now();
		this.updated_at = LocalDateTime.now();
	}

	

	public Product(long id, Category category, String title, String description, String imageUrl, double price,
			long quantity, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantity = quantity;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
}
