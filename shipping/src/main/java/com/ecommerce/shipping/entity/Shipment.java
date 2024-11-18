package com.ecommerce.shipping.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



import java.time.LocalDate;

@Entity
public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long orderId;
	private String userId;
	private Integer status;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public LocalDate getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(LocalDate shippingDate) {
		this.shippingDate = shippingDate;
	}
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	private String destination;
    private Double weight;
    private Double shippingCost;
    private LocalDate shippingDate;

    // Constructors, getters, and setters
    public Shipment() {}

	public Shipment(Long id, Long orderId, String userId, Integer status, String destination, Double weight,
			Double shippingCost, LocalDate shippingDate) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.userId = userId;
		this.status = status;
		this.destination = destination;
		this.weight = weight;
		this.shippingCost = shippingCost;
		this.shippingDate = shippingDate;
	}

}
