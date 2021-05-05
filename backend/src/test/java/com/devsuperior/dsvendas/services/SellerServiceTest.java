package com.devsuperior.dsvendas.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.devsuperior.dsvendas.dto.SellerDto;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

public class SellerServiceTest {

	private SellerService service;

	@Mock
	private SellerRepository repository;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		this.service = new SellerService(repository);
	}


	@Test
	public void shouldFindAllSellersDto() {
		Mockito.when(this.repository.findAll()).thenReturn(createSellers());
		List<SellerDto> sellers = this.service.findAll();

		Mockito.verify(this.repository).findAll();
		Assertions.assertFalse(sellers.isEmpty());
	}

	public List<Seller> createSellers() {
		Seller s1 = new Seller("Paulo");
		Seller s2 = new Seller("Henrique");
		Seller s3 = new Seller("Mauro");
		Seller s4 = new Seller("Gabriel");
		Seller s5 = new Seller("Luke Cage");
		return List.of(s1, s2, s3, s4, s5);
	}

}