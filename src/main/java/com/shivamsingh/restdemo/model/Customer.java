package com.shivamsingh.restdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String id;

    private String name;

    @ManyToMany(mappedBy = "customers")
    private Set<CloudVendor> cloudVendors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CloudVendor> getCloudVendors() {
        return cloudVendors;
    }

    public void setCloudVendors(Set<CloudVendor> cloudVendors) {
        this.cloudVendors = cloudVendors;
    }
}
