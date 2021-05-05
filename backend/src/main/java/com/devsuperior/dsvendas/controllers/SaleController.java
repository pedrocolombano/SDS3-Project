package com.devsuperior.dsvendas.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.services.SaleService;

@RestController
@RequestMapping(path = "/api/v1/sales")
public class SaleController {

	private SaleService saleService;
	
	@Autowired
	public SaleController(final SaleService saleService) {
		this.saleService = saleService;
	}
	
	@GetMapping
	public ResponseEntity<Page<SaleDto>> findAll(
			@PageableDefault (page = 0, size = 20, direction = Direction.DESC, sort = "amount") Pageable pageable) {
		Page<SaleDto> sales = this.saleService.findAll(pageable);
		return ResponseEntity.ok().body(sales);
	}

}
