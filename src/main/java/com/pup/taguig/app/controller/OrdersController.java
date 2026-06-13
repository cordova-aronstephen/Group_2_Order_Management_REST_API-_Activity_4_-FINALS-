package com.pup.taguig.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pup.taguig.app.dto.OrdersRequestDTO;
import com.pup.taguig.app.dto.OrdersResponseDTO;
import com.pup.taguig.app.service.OrdersService;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@PostMapping("/")
	public OrdersResponseDTO addOrders(@RequestBody OrdersRequestDTO request) {
		
		return ordersService.addOrder(request);
	}
	
	@GetMapping("/{id}")
	public OrdersResponseDTO getOrdersById(@PathVariable Long id) {
		
		return ordersService.getOrderById(id);
	} 
	
	@DeleteMapping("/{id}")
	public Boolean deleteOrderById(@PathVariable Long id) {
		
		return ordersService.deleteOrderById(id);
	}
}
