package com.devsuperior.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	private SaleRepository saleRepository;
	
	private SellerRepository sellerRepository;

	@Autowired
	public SaleService(final SaleRepository saleRepository, SellerRepository sellerRepository) {
		this.saleRepository = saleRepository;
		this.sellerRepository = sellerRepository;
	}

	@Transactional(readOnly = true)
	public Page<SaleDto> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> sales = this.saleRepository.findAll(pageable);
		return sales.map(sale -> new SaleDto(sale));
	}

}
