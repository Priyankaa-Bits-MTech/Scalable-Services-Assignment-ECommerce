package com.ecommerce.Shipping.controller;

//import com.ecommerce.Shipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ecommerce.Shipping.repository.ShipmentRepository;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipments")
public class ShippingController {

    @Autowired
    private ShipmentRepository shippingService;

  /*  @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return Shipping.createShipment(shipment);
    }*/
    @GetMapping
    public ResponseEntity<Object> getAllShipments() {
        return ResponseEntity.ok(shippingService.findAll());
    }
   

   /* 
     @GetMapping("/{id}")
    public Shipment getShipmentById(@PathVariable Long id) {
        return ShipmentRepository.getShipmentById(id);
    }

    @PutMapping("/{id}")
    public Shipment updateShipment(@PathVariable Long id, @RequestBody Shipment shipmentDetails) {
        return Shipping.updateShipment(id, shipmentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {
    	Shipping.deleteShipment(id);
    }*/
}