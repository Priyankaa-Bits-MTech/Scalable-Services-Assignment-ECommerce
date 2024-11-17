package com.ecommerce.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.products.repo.ProductRepository;


@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private ProductRepository  productRepo;
	
	@GetMapping
	private  ResponseEntity<Object> getAllProducts( @RequestHeader("userId") String userId) {
		System.out.println(userId);
		return ResponseEntity.ok(productRepo.findAll());
	}
	
}
