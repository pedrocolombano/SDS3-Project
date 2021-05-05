package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsvendas.dto.SaleSuccessDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query(value = "SELECT new com.devsuperior.dsvendas.dto.SaleSumDto(sale.seller, SUM(sale.amount)) "
			+ "FROM Sale AS sale GROUP BY sale.seller")
	List<SaleSumDto> amountGroupedBySeller();
	
	@Query(value = "SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDto(sale.seller, SUM(sale.visited), SUM(sale.deals)) "
			+ "FROM Sale AS sale GROUP BY sale.seller")
	List<SaleSuccessDto> successGroupedBySeller();
	
}
