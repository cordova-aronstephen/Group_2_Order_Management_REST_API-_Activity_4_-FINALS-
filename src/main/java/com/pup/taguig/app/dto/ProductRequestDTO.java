package com.pup.taguig.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
	
	private String name;
	private String description;
	private Float price;
	private Integer stock;
	
}
