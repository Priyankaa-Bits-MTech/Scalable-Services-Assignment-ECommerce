package com.ecommerce.users.service.impl;

import com.ecommerce.users.entity.Address;
import com.ecommerce.users.service.AddressService;
import com.ecommerce.users.repo.AddressRepository;
import com.ecommerce.users.helper.AddressMappingHelper;
import java.util.List;
import java.util.stream.Collectors;

public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return this.addressRepository.findAll()
                .stream()
                .map(AddressMappingHelper::map)
                .distinct()
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Address findById(Integer addressId) {
        return null;
    }

    @Override
    public Address save(Address Address) {
        return null;
    }

    @Override
    public Address update(Address Address) {
        return null;
    }

    @Override
    public Address update(Integer addressId, Address Address) {
        return null;
    }

    @Override
    public void deleteById(Integer addressId) {

    }
}
