package com.ecommerce.orders.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    private OrderData orderData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderData getOrderData() {
		return orderData;
	}

	public void setOrderData(OrderData orderData) {
		this.orderData = orderData;
	}

	public Product(Long id, OrderData orderData) {
		super();
		this.id = id;
		this.orderData = orderData;
	}

    
	public Product() {}
    
}
