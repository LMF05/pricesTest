package com.example.inditex.services;

import java.time.LocalDateTime;
import com.example.inditex.dtos.PricesDTO;

public interface PricesService {

	PricesDTO getPriceByDateAndProductAndBrand(LocalDateTime date, Long productId, Long brandId);
}
