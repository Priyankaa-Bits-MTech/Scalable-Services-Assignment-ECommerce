package com.ecommerce.Shipping.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



import java.time.LocalDate;

@Entity
public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public LocalDate getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(LocalDate shippingDate) {
		this.shippingDate = shippingDate;
	}

	private String destination;
    private Double weight;
    private Double shippingCost;
    private LocalDate shippingDate;

    // Constructors, getters, and setters
    public Shipment() {}

    public Shipment(String destination, Double weight, Double shippingCost, LocalDate shippingDate) {
        this.destination = destination;
        this.weight = weight;
        this.shippingCost = shippingCost;
        this.shippingDate = shippingDate;
    }

    // Getters and setters
}
