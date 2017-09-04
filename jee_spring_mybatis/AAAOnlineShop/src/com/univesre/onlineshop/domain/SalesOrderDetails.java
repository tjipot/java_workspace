package com.univesre.onlineshop.domain;

public class SalesOrderDetails implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer orderId;
	private Integer memberId;
	private String orderCreateTime;
	private Integer orderStatus;
	
	public SalesOrderDetails() {
		super();
	}

	// Getters and Setters;
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(String orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	@Override
	public String toString() {
		return "This Is SalesOrderDetails";
	}

}
