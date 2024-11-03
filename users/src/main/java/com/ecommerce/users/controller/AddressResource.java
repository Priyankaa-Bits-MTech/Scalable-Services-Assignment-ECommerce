package com.ecommerce.users.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ecommerce.users.entity.Address;
import com.ecommerce.users.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = {"/api/address"})
public class AddressResource {
    @Autowired
    private final AddressService addressService;
    @Autowired
    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
//        log.info("*** Address List, controller; fetch all addresss *");
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> findById(
            @PathVariable("addressId")
            @NotBlank(message = "Input must not blank")
            @Valid final String addressId) {
//        log.info("*** Address, resource; fetch address by id *");
        return ResponseEntity.ok(this.addressService.findById(Integer.parseInt(addressId.strip())));
    }

    @PostMapping
    public ResponseEntity<Address> save(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final Address Address) {
//        log.info("*** Address, resource; save address *");
        return ResponseEntity.ok(this.addressService.save(Address));
    }

    @PutMapping
    public ResponseEntity<Address> update(
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final Address Address) {
//        log.info("*** Address, resource; update address *");
        return ResponseEntity.ok(this.addressService.update(Address));
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<Address> update(
            @PathVariable("addressId")
            @NotBlank(message = "Input must not blank") final String addressId,
            @RequestBody
            @NotNull(message = "Input must not NULL")
            @Valid final Address Address) {
//        log.info("*** Address, resource; update address with addressId *");
        return ResponseEntity.ok(this.addressService.update(Integer.parseInt(addressId.strip()), Address));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("addressId") @NotBlank(message = "Input must not blank") @Valid final String addressId) {
//        log.info("*** Boolean, resource; delete address by id *");
        this.addressService.deleteById(Integer.parseInt(addressId));
        return ResponseEntity.ok(true);
    }
}
