package com.jacaranda.model;

import java.time.LocalDateTime;

public class Sale {
	private SaleId id;
	private int quantity;
	private double price;
	
	public Sale() {
		
	}

	public Sale(SaleId id, int quantity, double price) throws SaleException {
		super();
		setId(id);
		setQuantity(quantity);
		setPrice(price);
	}
	
	public SaleId getId() {
		return id;
	}

	public void setId(SaleId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) throws SaleException {
		if(quantity <0) {
			throw new SaleException("La cantidad no puede ser menor de 0.");
		} else {
			this.quantity = quantity;
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws SaleException {
		if(price < 0) {
			throw new SaleException("El precio no puede ser menor que 0.");
		} else {
			this.price = price;
		}
	}

	
	
	
}

//`ele_id` int(11) NOT NULL,
//`us_id` int(11) NOT NULL,
//`salesDate` datetime NOT NULL,
//`quantity` int(11) DEFAULT NULL,
//`price` double DEFAULT NULL