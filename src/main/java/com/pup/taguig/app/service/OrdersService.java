package com.pup.taguig.app.service;

import com.pup.taguig.app.dto.OrdersRequestDTO;
import com.pup.taguig.app.dto.OrdersResponseDTO;

public interface OrdersService {
	
	public OrdersResponseDTO addOrder(OrdersRequestDTO request);
	
}
