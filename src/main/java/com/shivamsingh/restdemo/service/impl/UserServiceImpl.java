package com.shivamsingh.restdemo.service.impl;

import com.shivamsingh.restdemo.model.Users;
import com.shivamsingh.restdemo.repository.UserRepository;
import com.shivamsingh.restdemo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users registerUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
