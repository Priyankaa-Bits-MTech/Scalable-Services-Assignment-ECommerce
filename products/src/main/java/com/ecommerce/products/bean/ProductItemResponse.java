package com.ecommerce.products.bean;

import com.ecommerce.products.entity.Product;

public class ProductItemResponse extends ProductBean {

	private String serverPort;

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public ProductItemResponse(Product product, String serverPort) {
		super();
		super.setId(product.getId());
		super.setTitle(product.getTitle());
		super.setDescription(product.getDescription());
		super.setImageUrl(product.getImageUrl());
		super.setPrice(product.getPrice());
		super.setQuantity(product.getQuantity());
		super.setCreated_at(product.getCreated_at());
		super.setUpdated_at(product.getUpdated_at());
		this.serverPort = serverPort;
	}

}
