package com.jacaranda.model;

import java.time.LocalDateTime;

public class SaleId {
	private int eleId; //database ele_id
	private int usId; //database us_id
	private LocalDateTime salesDate;

	public SaleId() {
		
	}
	
	public int getEleId() {
		return eleId;
	}

	public void setEleId(int eleId) {
		this.eleId = eleId;
	}

	public int getUsId() {
		return usId;
	}

	public void setUsId(int usId) {
		this.usId = usId;
	}

	public LocalDateTime getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(LocalDateTime salesDate) throws SaleIdException {
		
		if(salesDate.isAfter(LocalDateTime.now())) {
			throw new SaleIdException("La fecha de venta no puede ser superior a la fecha actual.");
		}
		this.salesDate = salesDate;
	}

}
