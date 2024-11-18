package com.ecommerce.orders.bean;

import java.time.LocalDateTime;
import java.util.List;

import com.ecommerce.orders.entity.OrderData;

public class OrderProductBean {
	private Integer orderId;

	private LocalDateTime orderDate;

	private String orderDesc;

	private Double orderFee;

	private List<ProductBean> products;

	public OrderProductBean() {
	}

	public OrderProductBean(OrderData order, List<ProductBean> products) {
		super();
		orderId = order.getOrderId();
		orderDate = order.getOrderDate();
		orderDesc = order.getOrderDesc();
		orderFee = order.getOrderFee();

		this.products = products;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Double getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(Double orderFee) {
		this.orderFee = orderFee;
	}

	public List<ProductBean> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBean> products) {
		this.products = products;
	}

}
