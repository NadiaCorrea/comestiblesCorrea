package com.jacaranda.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<CartItem> requestedItems = new ArrayList<>();
	

	public ShoppingCart() {
	}


	public List<CartItem> getRequestedItems() {
		return requestedItems;
	}


	public void setRequestedItems(List<CartItem> requestedItems) {
		this.requestedItems = requestedItems;
	}


	@Override
	public String toString() {
		return "ShoppingCart [requestedItems=" + requestedItems + "]";
	}
	
}
