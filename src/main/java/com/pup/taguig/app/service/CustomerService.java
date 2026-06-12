package com.pup.taguig.app.service;

import com.pup.taguig.app.dto.CustomerRequestDTO;
import com.pup.taguig.app.dto.CustomerResponseDTO;

public interface CustomerService {

    public CustomerResponseDTO registerCustomer(CustomerRequestDTO customerRequestDTO);

    public CustomerResponseDTO getCustomerById(int id);
}