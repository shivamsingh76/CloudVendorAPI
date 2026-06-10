package com.shivamsingh.restdemo.service;

import com.shivamsingh.restdemo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {

    public CloudVendor getCloudVendor(String vendorId);

    public List<CloudVendor> getAllCloudVendors();

    public String addCloudVendor(CloudVendor cloudVendor);

    public String updateCloudVendor(CloudVendor cloudVendor);

    public String deleteCloudVendor(String vendorId);
}
