package com.ecommerce.orders.repo;

import com.ecommerce.orders.entity.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends  JpaRepository<OrderData, Integer> {

}
