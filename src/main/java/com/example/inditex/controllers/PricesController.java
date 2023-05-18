package com.example.inditex.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.inditex.dtos.PricesDTO;
import com.example.inditex.services.PricesService;

@RestController
@RequestMapping("/api")
public class PricesController {

	@Autowired
    public PricesService pricesService;

    @GetMapping("/prices")
    public ResponseEntity<PricesDTO> getPrices(
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH.mm.ss") LocalDateTime date,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {
    	PricesDTO pricesDTO = pricesService.getPriceByDateAndProductAndBrand(date, productId, brandId);
        if (pricesDTO == null) {
        	return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pricesDTO);
    }
}

