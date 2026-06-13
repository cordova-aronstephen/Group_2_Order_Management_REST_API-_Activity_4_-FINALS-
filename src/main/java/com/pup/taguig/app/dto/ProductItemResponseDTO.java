package com.pup.taguig.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductItemResponseDTO {
	
	private Long productId;
	private int quantity;
	private float totalPrice;
	
}
