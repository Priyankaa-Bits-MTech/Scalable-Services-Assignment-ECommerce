package com.ecommerce.shipping.bean;

import java.time.LocalDate;

public class ShipmentReqBean {

	private Integer orderId;
	private String userId;
	private Integer status;

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

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
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
	public ShipmentReqBean() {
	}

	public ShipmentReqBean(Integer orderId, String userId, Integer status, String destination, Double weight,
			Double shippingCost, LocalDate shippingDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.status = status;
		this.destination = destination;
		this.weight = weight;
		this.shippingCost = shippingCost;
		this.shippingDate = shippingDate;
	}

}
