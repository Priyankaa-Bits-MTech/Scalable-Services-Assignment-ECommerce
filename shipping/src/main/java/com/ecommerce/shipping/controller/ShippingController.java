package com.ecommerce.shipping.controller;

//import com.ecommerce.Shipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shipping.bean.ShippingResponseBean;
import com.ecommerce.shipping.entity.Shipment;
import com.ecommerce.shipping.repository.ShipmentRepository;
import com.ecommerce.shipping.service.ShippingService;

@RestController
@RequestMapping("/shipments")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

  /*  @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return Shipping.createShipment(shipment);
    }*/
    @GetMapping
    public ResponseEntity<Object> getAllShipments() {
        return ResponseEntity.ok(shippingService.findAll());
    }
   
     @GetMapping("/{id}")
    public ResponseEntity<ShippingResponseBean> getShipmentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(shippingService.getById(id));
    }
/*
    @PutMapping("/{id}")
    public Shipment updateShipment(@PathVariable Long id, @RequestBody Shipment shipmentDetails) {
        return Shipping.updateShipment(id, shipmentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {
    	Shipping.deleteShipment(id);
    }*/
}