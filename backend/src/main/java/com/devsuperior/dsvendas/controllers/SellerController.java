package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDto;
import com.devsuperior.dsvendas.services.SellerService;

@RestController
@RequestMapping(path = "/api/v1/sellers")
public class SellerController {

	private SellerService sellerService;

	@Autowired
	public SellerController(final SellerService sellerService) {
		this.sellerService = sellerService;
	}

	@GetMapping
	public ResponseEntity<List<SellerDto>> findAll() {
		List<SellerDto> sellers = this.sellerService.findAll();
		return ResponseEntity.ok().body(sellers);
	}

}
