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
	private int totalQuantity;
	private Long statusId;
	private Float orderPriceTotal;
	private LocalDateTime createdAt;
	
}
