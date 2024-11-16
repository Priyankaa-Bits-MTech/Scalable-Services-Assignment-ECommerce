package com.ecommerce.users.entity;

public class RegisterUser {
    private String email;

    private String password;

    private String fullName;

    public String getPassword() {
        return this.password;
    }

    public void setPassword() {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return  this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
