package com.jacaranda.model;

import java.time.LocalDateTime;

public class CarItem {
	private int userId;
	private int elementId;
	private int quantity;
	private double price; 
	private LocalDateTime orderedDate;
	

	public CarItem() {
		
	}

	public CarItem(int userId, int elementId, int quantity, double price, LocalDateTime orderedDate) {
		super();
		this.userId = userId;
		this.elementId = elementId;
		this.quantity = quantity;
		this.price = price;
		this.orderedDate = orderedDate;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getElementId() {
		return elementId;
	}


	public void setElementId(int elementId) {
		this.elementId = elementId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}


	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}
	
	

}
