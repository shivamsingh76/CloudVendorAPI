package com.shivamsingh.restdemo.service.impl;

import com.shivamsingh.restdemo.exception.CloudVendorNotFoundException;
import com.shivamsingh.restdemo.model.CloudVendor;
import com.shivamsingh.restdemo.model.Customer;
import com.shivamsingh.restdemo.repository.CloudVendorRepository;
import com.shivamsingh.restdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    private CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("Cloud vendor not found.");
        return cloudVendorRepository.findById(vendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public String addCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success. Cloud Vendor saved in DB.";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success. Cloud Vendor updated in DB.";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        cloudVendorRepository.deleteById(vendorId);
        return "Cloud Vendor deleted from DB.";
    }

    @Override
    public CloudVendor aquireCustomer(String vendorId, Customer customer) {

         if (cloudVendorRepository.findById(vendorId).isEmpty())
             throw new CloudVendorNotFoundException("Requested cloud vendor not found");

        CloudVendor cloudVendor = cloudVendorRepository.findById(vendorId).get();

        cloudVendor.getCustomers().add(customer);
        customer.getCloudVendors().add(cloudVendor);

        cloudVendorRepository.save(cloudVendor);

        return cloudVendor;
    }
}
