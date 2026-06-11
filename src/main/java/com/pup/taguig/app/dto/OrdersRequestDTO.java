package com.pup.taguig.app.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersRequestDTO {
	
	private Long customerId;
	private List<ProductItemRequestDTO> items;
	
}
