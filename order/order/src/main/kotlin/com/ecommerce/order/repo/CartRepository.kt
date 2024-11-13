package com.ecommerce.order.repo

import com.ecommerce.order.entity.Cart
import org.springframework.data.jpa.repository.JpaRepository


interface CartRepository : JpaRepository<Cart?, Int?>