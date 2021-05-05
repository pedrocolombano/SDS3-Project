package com.devsuperior.dsvendas.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDto;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	private SellerRepository sellerRepository;

	@Autowired
	public SellerService(final SellerRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}

	public List<SellerDto> findAll() {
		List<Seller> sellers = this.sellerRepository.findAll();
		return Collections
				.unmodifiableList(sellers.stream().map(seller -> new SellerDto(seller)).collect(Collectors.toList()));
	}

}
