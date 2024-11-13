package com.ecommerce.users.entity;

import java.util.List;

public class ReqResp {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String name;
    private String city;
    private String role;
    private String email;
    private String password;
    private User user;
    private List<User> userList;
}
