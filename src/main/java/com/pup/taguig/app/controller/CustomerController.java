package com.pup.taguig.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pup.taguig.app.dto.CustomerRequestDTO;
import com.pup.taguig.app.dto.CustomerResponseDTO;
import com.pup.taguig.app.dto.OrdersResponseDTO;
import com.pup.taguig.app.service.CustomerService;
import com.pup.taguig.app.service.OrdersService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> registerCustomer(
            @RequestBody CustomerRequestDTO customerRequestDTO) {

        CustomerResponseDTO createdCustomer = customerService.registerCustomer(customerRequestDTO);

        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable int id) {

        CustomerResponseDTO customer = customerService.getCustomerById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    
    @GetMapping("/{id}/orders")
	public List<OrdersResponseDTO> retrieveAllOrdersByCustomerId(@PathVariable Long id) {
		
		return ordersService.retrieveAllOrdersByCustomerId(id);
	}
}