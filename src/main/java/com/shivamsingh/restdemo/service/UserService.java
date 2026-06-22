package com.shivamsingh.restdemo.service;

import com.shivamsingh.restdemo.model.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();

    Users registerUser(Users user);
}
