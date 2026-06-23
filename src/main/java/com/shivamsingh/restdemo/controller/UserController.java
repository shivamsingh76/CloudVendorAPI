package com.shivamsingh.restdemo.controller;

import com.shivamsingh.restdemo.model.Users;
import com.shivamsingh.restdemo.response.ResponseHandler;
import com.shivamsingh.restdemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return ResponseHandler.handleResponse(userService.getAllUsers(), "Users fetched successfully.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@RequestBody Users user) {
        return ResponseHandler.handleResponse(userService.registerUser(user), "User registeration successful.", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody Users user) {
        return ResponseHandler.handleResponse(userService.loginUser(user),
                "User login successful.",
                HttpStatus.OK);
    }
}
