package com.ecommerce.shipping.controller;

//import com.ecommerce.Shipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shipping.bean.ShipmentReqBean;
import com.ecommerce.shipping.bean.ShippingResponseBean;
import com.ecommerce.shipping.entity.Shipment;
import com.ecommerce.shipping.repository.ShipmentRepository;
import com.ecommerce.shipping.service.ShippingService;

@RestController
@RequestMapping("/shipments")
public class ShippingController {

	@Autowired
	private ShippingService shippingService;

	@PostMapping
	public ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {
		return ResponseEntity.status(HttpStatus.CREATED).body(shippingService.createShipmentInfo(shipment));
	}

	@GetMapping
	public ResponseEntity<Object> getAllShipments() {
		return ResponseEntity.ok(shippingService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShippingResponseBean> getShipmentById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(shippingService.getById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Shipment> updateShipment(@PathVariable("id") Long id, @RequestBody ShipmentReqBean shipmentDetails) {
		return ResponseEntity.ok(shippingService.updateshipping(id, shipmentDetails));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteShipment(@PathVariable("id") Long id) {
		shippingService.deleteShipping(id);
		return ResponseEntity.noContent().build();
	}
}