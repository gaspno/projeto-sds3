package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;
public class SellerDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long Id;
	private String name;
	
	

	public SellerDto()
	{
		
	}

	public SellerDto(Long id, String name) {
		super();
		Id = id;
		this.name = name;
	}
	
	public SellerDto(Seller entity) {
		super();
		Id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

