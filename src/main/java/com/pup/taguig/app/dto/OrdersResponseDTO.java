package com.pup.taguig.app.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersResponseDTO {
	
	private List<ProductItemResponseDTO> items;
	private Float OrderPriceTotal;
	
}
      