package com.pup.taguig.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pup.taguig.app.dto.CustomerRequestDTO;
import com.pup.taguig.app.dto.CustomerResponseDTO;
import com.pup.taguig.app.model.Customer;
import com.pup.taguig.app.repository.CustomerMapper;
import com.pup.taguig.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerResponseDTO registerCustomer(CustomerRequestDTO customerRequestDTO) {

        Customer existingCustomer = customerMapper.findByEmail(customerRequestDTO.getEmail());

        if (existingCustomer != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        Customer customer = new Customer();

        customer.setFirstName(customerRequestDTO.getFirstName());
        customer.setLastName(customerRequestDTO.getLastName());
        customer.setMiddleName(customerRequestDTO.getMiddleName());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setPhone(customerRequestDTO.getPhone());

        customerMapper.registerCustomer(customer);

        Customer createdCustomer = customerMapper.getCustomerById(customer.getId());

        return convertToResponseDTO(createdCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomerById(int id) {

        Customer customer = customerMapper.getCustomerById(id);

        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }

        return convertToResponseDTO(customer);
    }

    private CustomerResponseDTO convertToResponseDTO(Customer customer) {

        CustomerResponseDTO responseDTO = new CustomerResponseDTO();

        responseDTO.setFirstName(customer.getFirstName());
        responseDTO.setLastName(customer.getLastName());
        responseDTO.setMiddleName(customer.getMiddleName());

        return responseDTO;
    }
}