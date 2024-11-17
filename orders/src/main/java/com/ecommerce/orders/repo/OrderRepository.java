package com.ecommerce.orders.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.orders.entity.Cart;


public interface OrderRepository extends  JpaRepository<Cart, Integer> {

}
