package com.pup.taguig.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
	
	private Long id;
	private String name;
	private String description;
	private Float price;
	private Integer stock;
	
}
