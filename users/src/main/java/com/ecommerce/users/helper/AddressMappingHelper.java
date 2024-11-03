package com.ecommerce.users.helper;

import com.ecommerce.users.entity.Address;

public class AddressMappingHelper {
    public static Address map(final Address address) {
        return Address.builder()
                .addressId(address.getAddressId())
                .fullAddress(address.getFullAddress())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
//                .userDto(
//                        UserDto.builder()
//                                .userId(address.getUser().getUserId())
//                                .firstName(address.getUser().getFirstName())
//                                .lastName(address.getUser().getLastName())
//                                .imageUrl(address.getUser().getImageUrl())
//                                .email(address.getUser().getEmail())
//                                .phone(address.getUser().getPhone())
//                                .build())
                .build();
    }
}
