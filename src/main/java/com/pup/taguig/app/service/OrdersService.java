package com.pup.taguig.app.service;

import java.util.List;

import com.pup.taguig.app.dto.OrdersRequestDTO;
import com.pup.taguig.app.dto.OrdersResponseDTO;

public interface OrdersService {
	
	public OrdersResponseDTO addOrder(OrdersRequestDTO request);
	public OrdersResponseDTO getOrderById(Long id);
	public List<OrdersResponseDTO> retrieveAllOrdersByCustomerId(Long id);
	public Boolean deleteOrderById(Long id);
	
}

