package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SellerDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public SellerDto() {

	}

	public SellerDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public SellerDto(Seller entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
