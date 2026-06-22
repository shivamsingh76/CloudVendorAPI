package com.shivamsingh.restdemo.service.impl;

import com.shivamsingh.restdemo.model.Users;
import com.shivamsingh.restdemo.model.UserPrinciple;
import com.shivamsingh.restdemo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByUsername(username);

        if(user.isEmpty()) {
            System.out.println("User not found.");
            throw new UsernameNotFoundException("User not found.");
        }

        return new UserPrinciple(user.get());
    }
}
