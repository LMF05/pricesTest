package com.example.inditex.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inditex.dtos.PricesDTO;
import com.example.inditex.entities.Prices;
import com.example.inditex.repositories.PricesRepository;
import com.example.inditex.services.PricesService;

@Service
public class PricesServiceImpl implements PricesService{

	@Autowired
	public PricesRepository pricesRepository;

	@Override
	public PricesDTO getPriceByDateAndProductAndBrand(LocalDateTime date, Long productId, Long brandId) {
		List<Prices> prices = pricesRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
                date, date, productId, brandId);
        if (prices.isEmpty()) {
            return null;
        }
        Prices selectedPrice = prices.get(0);
        PricesDTO pricesDTO = new PricesDTO();
        pricesDTO.setProductId(selectedPrice.getProductId());
        pricesDTO.setBrandId(selectedPrice.getBrandId());
        pricesDTO.setPriceList(selectedPrice.getPriceList());
        pricesDTO.setStartDate(selectedPrice.getStartDate());
        pricesDTO.setEndDate(selectedPrice.getEndDate());
        pricesDTO.setPrice(selectedPrice.getPrice());
        return pricesDTO;
	}	
}
