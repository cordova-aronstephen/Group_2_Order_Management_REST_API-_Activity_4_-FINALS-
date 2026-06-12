package com.pup.taguig.app.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {
	
	private Long id;
	private String name;
	private LocalDateTime createdAt;
	
}
