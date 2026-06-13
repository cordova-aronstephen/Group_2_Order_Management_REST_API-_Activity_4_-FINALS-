package com.pup.taguig.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersResponseDTO {
	
	private Long customerId; 
	private List<ProductItemResponseDTO> items;
	private int totalQuantity;
	private Float OrderPriceTotal;
	
}
      