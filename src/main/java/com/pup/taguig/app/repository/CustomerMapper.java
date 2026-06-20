package com.pup.taguig.app.repository;

import org.apache.ibatis.annotations.Mapper;

import com.pup.taguig.app.model.Customer;

@Mapper
public interface CustomerMapper {

    public void registerCustomer(Customer customer);

    public Customer findByEmail(String email);

    public Customer getCustomerById(int id);
    
    public void update(Customer customer);
}