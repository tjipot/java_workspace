package com.univesre.onlineshop.domain;

import java.util.HashMap;

public class ShoppingCart implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer> cartItemAmount;
	
	public ShoppingCart() {
		super();
	}

	// Getters and Setters;
	public HashMap<String, Integer> getCartItemAmount() {
		return cartItemAmount;
	}

	public void setCartItemAmount(HashMap<String, Integer> cartItemAmount) {
		this.cartItemAmount = cartItemAmount;
	}

	@Override
	public String toString() {
		return "This Is ShoppingCart.java";
	}
	
}
