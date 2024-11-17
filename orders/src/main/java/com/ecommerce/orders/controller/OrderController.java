package com.ecommerce.orders.controller;

import com.ecommerce.orders.entity.OrderData;
import com.ecommerce.orders.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // Get all orders
    @GetMapping
    public ResponseEntity<List<OrderData>> getAllOrders() {
        List<OrderData> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

    // Get a specific order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderData> getOrderById(@PathVariable Integer orderId) {
        OrderData order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        return ResponseEntity.ok(order);
    }

    // Create a new order
    @PostMapping
    public ResponseEntity<OrderData> createOrder(@RequestBody OrderData orderData) {
        OrderData createdOrder = orderRepository.save(orderData);
        return ResponseEntity.status(201).body(createdOrder);
    }

    // Update an existing order
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderData> updateOrder(
            @PathVariable Integer orderId,
            @RequestBody OrderData updatedOrderData) {
        OrderData existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        existingOrder.setOrderDate(updatedOrderData.getOrderDate());
        existingOrder.setOrderDesc(updatedOrderData.getOrderDesc());
        existingOrder.setOrderFee(updatedOrderData.getOrderFee());
        existingOrder.setCart(updatedOrderData.getCart());
        OrderData updatedOrder = orderRepository.save(existingOrder);
        return ResponseEntity.ok(updatedOrder);
    }

    // Delete an order
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId) {
        orderRepository.deleteById(orderId);
        return ResponseEntity.noContent().build();
    }

}
