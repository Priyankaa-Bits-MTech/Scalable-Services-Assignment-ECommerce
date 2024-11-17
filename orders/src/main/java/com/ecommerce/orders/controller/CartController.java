package com.ecommerce.orders.controller;

import com.ecommerce.orders.entity.Cart;
import com.ecommerce.orders.repo.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
    private CartRepository cartRepository;

    @GetMapping
    public ResponseEntity<?> getCart() {
        return ResponseEntity.ok(cartRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        Cart savedCart = cartRepository.save(cart);
        return ResponseEntity.ok(savedCart);
    }
}

