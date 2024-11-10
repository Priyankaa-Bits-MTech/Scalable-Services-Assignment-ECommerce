package com.ecommerce.users.services;

import com.ecommerce.users.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();
    public String registerUser(String userName, Long mobileNo, String emailId, String address, int pinCode,
                               String password);

    public String registerUser(User user);

    public boolean isRegistered(String emailId);

    public String isValidCredential(String emailId, String password);

    public User getUserDetails(String emailId);

    User saveUser(User newUser);

    Optional<User> findUserById(Long id);

    void deleteUserById(Long id);
}
