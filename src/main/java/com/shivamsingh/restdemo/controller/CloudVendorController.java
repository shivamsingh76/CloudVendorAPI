package com.shivamsingh.restdemo.controller;

import com.shivamsingh.restdemo.model.CloudVendor;
import com.shivamsingh.restdemo.model.Customer;
import com.shivamsingh.restdemo.response.ResponseHandler;
import com.shivamsingh.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cloud-vendors")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<Object> getCloudVendor(@PathVariable("vendorId") String vendorId) {
        return ResponseHandler.handleResponse(cloudVendorService.getCloudVendor(vendorId), "Requested Cloud Vendor Found.", HttpStatus.OK);
    }

    @GetMapping
    public List<CloudVendor> getCloudVendors() {
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String addCloudVendor(@RequestBody CloudVendor cloudVendor) {
        return cloudVendorService.addCloudVendor(cloudVendor);
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor) {
        return cloudVendorService.updateCloudVendor(cloudVendor);
    }

    @DeleteMapping("/{vendorId}")
    public String deleteVendor(@PathVariable("vendorId") String vendorId) {
        return cloudVendorService.deleteCloudVendor(vendorId);
    }

    @PatchMapping("/{vendorId}/customers")
    public ResponseEntity<Object> aquireCustomer(
            @PathVariable("vendorId") String vendorId, @RequestBody Customer customer) {

        return ResponseHandler.handleResponse(
                cloudVendorService.aquireCustomer(vendorId, customer),
                "Customer successfully aquired by cloud vendor.",
                HttpStatus.OK);
    }

}