package com.ecommerce.order.controllers

import com.ecommerce.order.entity.Cart
import com.ecommerce.order.repo.CartRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cart")
class CartController (
    private val cartRepository: CartRepository
){

    @GetMapping("/")
    fun getCart(): ResponseEntity<Any?> {
        return ResponseEntity.ok(cartRepository.findAll())
    }

    @PostMapping("/add")
    fun addCart(@RequestBody cart: Cart): ResponseEntity<Cart> {
        val savedCart = cartRepository.save(cart)
        return ResponseEntity.ok(savedCart)
    }

}