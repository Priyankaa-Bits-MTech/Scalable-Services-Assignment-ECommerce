package com.ecommerce.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shipping.entity.Shipment;



public interface ShippingOrderRepository extends JpaRepository<Shipment, Long> {
    java.util.Optional<Shipment> findByOrderId(Long orderId);

}