package com.pup.taguig.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductItemResponseDTO {
	
	private Long productId;
	private int quantity;
	private float totalPrice;
	
}
