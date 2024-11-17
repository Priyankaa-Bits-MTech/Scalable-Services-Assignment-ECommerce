package com.ecommerce.shipping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.shipping.entity.Shipment;
import com.ecommerce.shipping.repository.ShippingOrderRepository;


import java.util.Optional;

@Service
public class ShippingService {

    @Autowired
    private ShippingOrderRepository repository;
    
    public Shipment createShippingOrder(Shipment shipment) {
        return repository.save(shipment);
    }
    
    public Optional<Shipment> getshippingByOrderId(Long orderId) {
        return repository.findById(orderId);
    }
    
	public Shipment updateshipping(Long orderId, Shipment shipment) {
	        Optional<Shipment> existingProduct = repository.findByOrderId(orderId);
	        if (existingProduct.isPresent()) {
	        	Shipment shipupdate = existingProduct.get();
	        	shipupdate.setDestination(shipment.getDestination());
	        	shipupdate.setShippingCost(shipment.getShippingCost());
	        	shipupdate.setShippingDate(shipment.getShippingDate());
	        	shipupdate.setOrderId(shipment.getOrderId());
	        	shipupdate.setUserId(shipment.getUserId());
	        	shipupdate.setStatus(shipment.getStatus());
	            return repository.save(shipment);
	        } else {
	            throw new RuntimeException("Shipping not found");
	        }
	    
	}

	public void deleteShipping(Long id) {
		repository.deleteById(id);
    }

}