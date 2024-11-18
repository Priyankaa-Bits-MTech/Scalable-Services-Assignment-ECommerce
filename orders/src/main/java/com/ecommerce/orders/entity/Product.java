package com.ecommerce.orders.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    private OrderData orderData;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderData getOrderData() {
		return orderData;
	}

	public void setOrderData(OrderData orderData) {
		this.orderData = orderData;
	}

	public Product(Integer id, OrderData orderData) {
		super();
		this.id = id;
		this.orderData = orderData;
	}

    
	public Product() {}
    
}
