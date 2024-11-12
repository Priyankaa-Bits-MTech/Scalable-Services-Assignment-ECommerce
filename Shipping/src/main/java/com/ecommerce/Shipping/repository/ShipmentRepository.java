package com.ecommerce.Shipping.repository;

import com.ecommerce.Shipping.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

}

