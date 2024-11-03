package com.ecommerce.users.service;

import java.util.List;
import com.ecommerce.users.entity.Address;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Component
@Repository
public interface AddressService {
    List<Address> findAll();
    Address findById(final Integer addressId);
    Address save(final Address Address);
    Address update(final Address Address);
    Address update(final Integer addressId, final Address Address);
    void deleteById(final Integer addressId);
}
