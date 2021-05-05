package com.devsuperior.dsvendas.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.devsuperior.dsvendas.entities.Seller;

public class SaleSumDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private BigDecimal sum;
	
	public SaleSumDto() {
		
	}
	
	public SaleSumDto(Seller seller, BigDecimal sum) {
		this.sellerName = seller.getName();
		this.sum = sum;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	
}
