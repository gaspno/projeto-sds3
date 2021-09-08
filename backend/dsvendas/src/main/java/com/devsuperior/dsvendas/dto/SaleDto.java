package com.devsuperior.dsvendas.dto;

import java.io.Serializable;
import java.time.LocalDate;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.entities.Seller;


public class SaleDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private int visited;
	private int deals;
	private double amount;
	private LocalDate date;
	private SellerDto seller;
	
	public SaleDto() {
		
	}

	public SaleDto(Sale entity) {
		super();
		this.id = entity.getId();
		this.visited = entity.getVisited();
		this.deals = entity.getDeals();
		this.amount =entity.getAmount();
		date = entity.getDate();
		this.seller=new SellerDto(entity.getSeller());
	}

	public SaleDto(Long id, int visited, int deals, double amount, LocalDate date,Seller seller) {
		super();
		this.id = id;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
		this.seller=new SellerDto(seller);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVisited() {
		return visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}

	public int getDeals() {
		return deals;
	}

	public void setDeals(int deals) {
		this.deals = deals;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public SellerDto getSeller() {
		return seller;
	}

	
	
	
	

}
