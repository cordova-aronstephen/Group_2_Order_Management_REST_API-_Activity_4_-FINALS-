package com.pup.taguig.app.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private Long id;
	private String name;
	private String description;
	private Float price;
	private Integer stock;
	private LocalDateTime createdAt;
	
}
