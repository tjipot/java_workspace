package com.univesre.onlineshop.domain;

public class SalesItem implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer item_id;
	private String item_name;
	private String item_category;
	private String item_description;
	private double item_price;
	private Integer item_amount;
	private double item_weight;

	public SalesItem() {
		super();
	}

	// Getters and Setters;
	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

	public Integer getItem_amount() {
		return item_amount;
	}

	public void setItem_amount(Integer item_amount) {
		this.item_amount = item_amount;
	}

	public double getItem_weight() {
		return item_weight;
	}

	public void setItem_weight(double item_weight) {
		this.item_weight = item_weight;
	}
	
	@Override
	public String toString() {
		return "This is SalesItem toString()";
	}
	
}
