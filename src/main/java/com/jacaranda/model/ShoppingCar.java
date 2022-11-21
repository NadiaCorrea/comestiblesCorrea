package com.jacaranda.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCar {
	private List<CarItem> requestedItems = new ArrayList<>();; 
	

	public ShoppingCar() {
		this.requestedItems = null;
	}


	public List<CarItem> getRequestedItems() {
		return requestedItems;
	}


	public void setRequestedItems(List<CarItem> requestedItems) {
		this.requestedItems = requestedItems;
	}

}
