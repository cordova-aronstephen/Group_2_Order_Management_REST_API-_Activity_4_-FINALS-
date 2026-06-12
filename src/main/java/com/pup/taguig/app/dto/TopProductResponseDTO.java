package com.pup.taguig.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopProductResponseDTO {

    private int productId;
    private String productName;
    private int totalQuantitySold;
    private double revenue;
}