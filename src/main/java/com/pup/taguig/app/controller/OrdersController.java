package com.pup.taguig.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
