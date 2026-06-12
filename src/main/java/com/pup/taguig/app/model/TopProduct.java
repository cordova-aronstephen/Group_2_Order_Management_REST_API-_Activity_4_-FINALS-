package com.pup.taguig.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopProduct {

    private int productId;
    private String productName;
    private int totalQuantitySold;
    private double revenue;
}