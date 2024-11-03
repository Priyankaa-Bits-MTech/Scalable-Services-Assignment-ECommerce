package com.ecommerce.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
public class Address {
    @Id
    @GeneratedValue
    private long addressId;

    private String fullAddress;

    private String postalCode;

    @Getter
    private String city;

    public Address() {
        super();
        this.addressId = 0;
        this.fullAddress = "";
        this.postalCode = "";
        this.city = "";
    }

    public Address(long id, String fullAddress, String postalCode, String city) {
        this.addressId = id;
        this.fullAddress = fullAddress;
        this.postalCode = postalCode;
        this.city = city;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId (long id) {
        this.addressId = id;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity(String city) {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

}
