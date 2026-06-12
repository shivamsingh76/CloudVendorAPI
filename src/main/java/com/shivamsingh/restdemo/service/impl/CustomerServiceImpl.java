package com.shivamsingh.restdemo.service.impl;

import com.shivamsingh.restdemo.model.Customer;
import com.shivamsingh.restdemo.repository.CustomerRepository;
import com.shivamsingh.restdemo.service.CutomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CutomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        customerRepository.save(customer);
        return true;
    }
}
