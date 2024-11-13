package com.ecommerce.order.repo

import com.ecommerce.order.entity.OrderData
import org.springframework.data.jpa.repository.JpaRepository


interface OrderRepository : JpaRepository<OrderData?, Int?>