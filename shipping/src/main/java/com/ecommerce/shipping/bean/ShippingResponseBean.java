package com.ecommerce.shipping.bean;

import com.ecommerce.shipping.entity.Shipment;

public class ShippingResponseBean {
	   private Long id;
		private OrderProductBean order;
		private String userId;
		private Integer status;
		
		
		public ShippingResponseBean(Shipment shipment, OrderProductBean order) {
			super();
			this.id = shipment.getId();
			this.order = order;
			this.userId = shipment.getUserId();
			this.status = shipment.getStatus();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public OrderProductBean getOrder() {
			return order;
		}
		public void setOrder(OrderProductBean order) {
			this.order = order;
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
		
}
