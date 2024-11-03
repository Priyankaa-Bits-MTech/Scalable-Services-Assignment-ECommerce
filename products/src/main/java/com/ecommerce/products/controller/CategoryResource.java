package com.ecommerce.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.products.repo.CategoryRepository;
import com.ecommerce.products.repo.ProductRepository;


@RestController
@RequestMapping("/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryRepository  categoryRepo;

	@GetMapping
	private  ResponseEntity<Object> getAllCategories() {
		return ResponseEntity.ok(categoryRepo.findAll());
	
	}
	

}