package com.ecommerce.orders.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    private Integer userId;

    @JsonIgnore
    @OneToMany(mappedBy = "cart")
    private Set<OrderData> orders;

    public Cart(Integer cartId, Integer userId, Set<OrderData> orders) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.orders = orders;
	}
    
    public Cart() {
		super();
		this.cartId = 0;
		this.userId = 0;
		this.orders = new HashSet<OrderData>();
	}
    

	private static final long serialVersionUID = 1L;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Set<OrderData> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderData> orders) {
		this.orders = orders;
	}
    
}

