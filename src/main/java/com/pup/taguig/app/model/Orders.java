package com.pup.taguig.app.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Orders {
	
	private Long id;
	private Long customerId;
	private Long productId;
	private int quantity;
	private Long statusId;
	private Float totalPrice;
	private LocalDateTime createdAt;
	
}
