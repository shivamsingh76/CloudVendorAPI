package com.shivamsingh.restdemo.controller;

import com.shivamsingh.restdemo.model.CloudVendor;
import com.shivamsingh.restdemo.service.CloudVendorService;
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
    public CloudVendor getCloudVendor(@PathVariable("vendorId") String vendorId) {
        return cloudVendorService.getCloudVendor(vendorId);
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

}