package com.ecommerce.orders.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    

    private String userId;

    @JsonIgnore
    @OneToMany(mappedBy = "cart")
    private Set<OrderData> orders;

    public Cart(Integer cartId, String userId, Set<OrderData> orders) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.orders = orders;
	}
    
    public Cart() {}
    

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Set<OrderData> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderData> orders) {
		this.orders = orders;
	}
    
}

