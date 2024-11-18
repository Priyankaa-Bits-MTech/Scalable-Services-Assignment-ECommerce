package com.ecommerce.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.products.entity.Product;
import com.ecommerce.products.repo.ProductRepository;


@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private ProductRepository  productRepo;
	
	@GetMapping
	private  ResponseEntity<List<Product>> getAllProducts(@RequestParam(name = "items",required = false) List<Long> items) {
		if(items==null || items.isEmpty()) {
		return ResponseEntity.ok(productRepo.findAll());
		}
		return ResponseEntity.ok(productRepo.findAllById(items));
	}
}
