package com.pup.taguig.app.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersItem {
	
	private Long id;
	private Long orderId;
	private Long productId;
	private float totalPrice;
	private int quantity;
	private LocalDateTime createdAt;
}
