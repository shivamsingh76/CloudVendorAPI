package com.shivamsingh.restdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String id;

    private String name;

    @ManyToMany(mappedBy = "customers")
    @JsonIgnore
    private Set<CloudVendor> cloudVendors = new HashSet<>();

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
