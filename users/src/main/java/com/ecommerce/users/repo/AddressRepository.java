package com.ecommerce.users.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.users.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}