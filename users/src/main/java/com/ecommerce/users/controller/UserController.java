package com.ecommerce.users.controller;

import com.ecommerce.users.entity.User;
import com.ecommerce.users.exception.UserNotFoundException;
import com.ecommerce.users.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"})
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> allUsers() {
        return userService.findAll();
    }


    @PostMapping("/users")
    String newUser(@RequestBody User newUser) {
        return userService.registerUser(newUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    Optional<User> getUserById(@PathVariable Long id) {

        return Optional.ofNullable(userService.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    @GetMapping("/users/email/{email}")
    User getUserByEmail(@PathVariable String email) {

        return userService.getUserDetails(email);
    }

    @GetMapping("/users/valid/{email}/{password}")
    String isUserValid(@PathVariable String email, @PathVariable String password) {

        return userService.isValidCredential(email, password);
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return userService.findUserById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    return userService.saveUser(newUser);
                })
                .orElseGet(() -> {
                    return userService.saveUser(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
