package com.ecommerce.orders.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.orders.bean.ProductBean;

@FeignClient(name = "products")
public interface ProductServiceProxy {

	@GetMapping("/products")
	public   ResponseEntity<List<ProductBean>> getAllProducts(@RequestParam(name = "items",required = false) List<Long> items);
}
