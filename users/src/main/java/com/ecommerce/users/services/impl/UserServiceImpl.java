package com.ecommerce.users.services.impl;

import com.ecommerce.users.entity.User;
import com.ecommerce.users.repository.UserRepository;
import com.ecommerce.users.services.UserService;
import com.ecommerce.users.utility.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public String registerUser(String userName, Long mobileNo, String emailId, String address, int pinCode,
                               String password) {

        User user = new User(userName, mobileNo, emailId, address, pinCode, password);

        String status = registerUser(user);

        return status;
    }

    @Override
    public String registerUser(User user) {
        //ReqRes resp = new ReqRes();
        String status = "";
        try {
            User newUser = new User();
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            newUser.setAddress(user.getAddress());
            newUser.setMobile(user.getMobile());
            newUser.setPinCode(user.getPinCode());
            User newUserResult = userRepository.save(newUser);
            if (newUserResult.getId()>0) {
                //resp.setOurUsers((ourUsersResult));
                status =  "User Saved Successfully";
                //resp.setStatusCode(200);
            }

        }catch (Exception e){
            status = "Failure";
        }
        //return resp;

//        String status = "User Registration Failed!";
//
//        boolean isRegtd = isRegistered(user.getEmail());
//
//        if (isRegtd) {
//            status = "Email Id Already Registered!";
//            return status;
//        }
//        Connection conn = DBUtil.provideConnection();
//        PreparedStatement ps = null;
//        if (conn != null) {
//            System.out.println("Connected Successfully!");
//        }
//
//        try {
//
//            ps = conn.prepareStatement("insert into users values(?,?,?,?,?,?)");
//
//            ps.setString(1, user.getEmail());
//            ps.setString(2, user.getName());
//            ps.setLong(3, user.getMobile());
//            ps.setString(4, user.getAddress());
//            ps.setInt(5, user.getPinCode());
//            ps.setString(6, user.getPassword());
//
//            int k = ps.executeUpdate();
//
//            if (k > 0) {
//                status = "User Registered Successfully!";
////                MailMessage.registrationSuccess(user.getEmail(), user.getName().split(" ")[0]);
//            }
//
//        } catch (SQLException e) {
//            status = "Error: " + e.getMessage();
//            e.printStackTrace();
//        }
//
//        DBUtil.closeConnection(ps);
//        DBUtil.closeConnection(ps);
//
        return status;
    }

    @Override
    public boolean isRegistered(String emailId) {
        boolean flag = false;
        List<User> allUsers = findAll();
        for (User currentUser: allUsers) {
            if(currentUser.getEmail().equals(emailId)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public String isValidCredential(String emailId, String password) {
        String status = "Login Denied! Incorrect Username or Password";

        List<User> allUsers = findAll();
        for (User currentUser: allUsers) {
            if(currentUser.getEmail().equals(emailId) && currentUser.getPassword().equals(password)) {
                status = "Valid User!";
                break;
            }
        }
        return status;
    }

    @Override
    public User getUserDetails(String emailId) {

        User user = null;

        List<User> allUsers = userRepository.findAll();
        for(User currentUser : allUsers){
            if(currentUser.getEmail().equals(emailId)){
                user = currentUser;
                break;
            }
        }

        return user;
    }

    @Override
    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
