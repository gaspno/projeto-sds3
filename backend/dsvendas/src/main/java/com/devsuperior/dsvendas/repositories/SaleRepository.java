package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSucessDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("select new com.devsuperior.dsvendas.dto.SaleSumDto(obj.seller,SUM(obj.amount))"
			+ "from Sale as obj group by obj.seller")
	List<SaleSumDto> amountGroupedBySeller();
	@Query("select new com.devsuperior.dsvendas.dto.SaleSucessDto(obj.seller,SUM(obj.visited),SUM(obj.deals))"
			+ "from Sale as obj group by obj.seller")
	List<SaleSucessDto> sucessGroupedBySeller();
	

}
