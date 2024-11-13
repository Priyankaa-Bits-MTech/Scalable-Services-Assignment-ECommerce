package com.ecommerce.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shipping.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

}

