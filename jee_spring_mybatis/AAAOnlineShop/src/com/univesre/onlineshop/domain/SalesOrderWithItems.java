package com.univesre.onlineshop.domain;

public class SalesOrderWithItems implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer orderId;
	private Integer itemId;

	// Getters and Setters;
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "This Is SalesOrderWithItems";
	}

}
