package com.ecommerce.shipping.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.shipping.bean.OrderProductBean;


@FeignClient(name = "orders")
public interface OrderServiceProxy {

	 @GetMapping("/orders/{orderId}")
	    public ResponseEntity<OrderProductBean> getOrderById(@PathVariable("orderId") Integer orderId);
}

