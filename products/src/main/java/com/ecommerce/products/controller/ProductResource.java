package com.ecommerce.products.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ecommerce.products.bean.ProductBean;
import com.ecommerce.products.bean.ProductItemResponse;
import com.ecommerce.products.entity.Product;
import com.ecommerce.products.repo.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private Environment env;

	@Autowired
	private ProductRepository productRepo;

	@GetMapping
	private ResponseEntity<List<Product>> getAllProducts(
			@RequestParam(name = "items", required = false) List<Long> items) {
		if (items == null || items.isEmpty()) {
			return ResponseEntity.ok(productRepo.findAll());
		}
		return ResponseEntity.ok(productRepo.findAllById(items));
	}

	@GetMapping("/{productId}")
	private ResponseEntity<ProductItemResponse> getProductById(@PathVariable("productId") Long productId) {

		if (productId == null) {
			return ResponseEntity.notFound().build();
		}

		Optional<Product> product = productRepo.findById(productId);
		if (!product.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		ProductItemResponse productResponse = new ProductItemResponse(product.get(), env.getProperty("server.port"));

		return ResponseEntity.ok(productResponse);
	}
	
	@PostMapping
	private ResponseEntity<Product> createProduct(@RequestBody ProductBean product){
		
		Product productDb= new Product();
		productDb.setDescription(product.getDescription());
		productDb.setTitle(product.getTitle());
		productDb.setImageUrl(product.getImageUrl());
		productDb.setPrice(product.getPrice());
		productDb.setQuantity(product.getQuantity());
		productDb.setUpdated_at(LocalDateTime.now());
		productDb.setCreated_at(LocalDateTime.now());
		var savedProduct=productRepo.save(productDb);
		
		URI uri = UriComponentsBuilder
				.fromUriString("/products/"+savedProduct.getId())
				.encode()
				.build()
				.toUri();
		
		return ResponseEntity.created(uri).body(savedProduct);
	} 
	
	
	
	@PutMapping("/{productId}")
	private ResponseEntity<Product> updateProduct(@RequestBody ProductBean product,@PathVariable("productId") Long productId){
		
		if (productId == null) {
			return ResponseEntity.notFound().build();
		}

		Optional<Product> OptionalProductDb = productRepo.findById(productId);
		if (!OptionalProductDb.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Product productDb= OptionalProductDb.get();
		productDb.setDescription(product.getDescription());
		productDb.setTitle(product.getTitle());
		productDb.setImageUrl(product.getImageUrl());
		productDb.setPrice(product.getPrice());
		productDb.setQuantity(product.getQuantity());
		productDb.setUpdated_at(LocalDateTime.now());
	
		return ResponseEntity.ok(productRepo.save(productDb));
	} 
	
	@PatchMapping("/{productId}")
	private ResponseEntity<Product> patchProduct(@RequestBody ProductBean product,@PathVariable("productId") Long productId){
		
		if (productId == null) {
			return ResponseEntity.notFound().build();
		}

		Optional<Product> OptionalProductDb = productRepo.findById(productId);
		if (!OptionalProductDb.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Product productDb= OptionalProductDb.get();
		if(!product.getDescription().isBlank()) {
		productDb.setDescription(product.getDescription());
		}
		if(!product.getTitle().isBlank()) {
		productDb.setTitle(product.getTitle());
		}
		if(!product.getImageUrl().isBlank()) {
		productDb.setImageUrl(product.getImageUrl());
		}
		if(product.getPrice()>0) {
		productDb.setPrice(product.getPrice());
		}
		if(product.getQuantity()>0) {
		productDb.setQuantity(product.getQuantity());
		}
		productDb.setUpdated_at(LocalDateTime.now());
	
		return ResponseEntity.ok(productRepo.save(productDb));
	} 
	
	@DeleteMapping("/{productId}")
	private ResponseEntity<Object> deleteProductById(@PathVariable("productId") Long productId) {

		if (productId == null) {
			return ResponseEntity.notFound().build();
		}

		Optional<Product> product = productRepo.findById(productId);
		if (!product.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		productRepo.delete(product.get());

		return ResponseEntity.noContent().build();
	}
}
