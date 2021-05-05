package com.devsuperior.dsvendas.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Sale;

public class SaleDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer visited;
	private Integer deals;
	private BigDecimal amount;
	private LocalDate date;

	private SellerDto seller;

	public SaleDto() {

	}

	public SaleDto(Long id, Integer visited, Integer deals, BigDecimal amount, LocalDate date, SellerDto seller) {
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}

	public SaleDto(Sale entity) {
		this.id = entity.getId();
		this.visited = entity.getVisited();
		this.deals = entity.getDeals();
		this.amount = entity.getAmount();
		this.date = entity.getDate();
		this.seller = new SellerDto(entity.getSeller());
	}

	public Long getId() {
		return id;
	}

	public Integer getVisited() {
		return visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public SellerDto getSeller() {
		return seller;
	}
	
}
