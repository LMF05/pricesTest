package com.example.inditex.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PricesDTO {

	private Long productId;
    private Long brandId;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;
    
}
