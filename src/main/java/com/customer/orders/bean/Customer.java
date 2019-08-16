package com.customer.orders.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

	private int orderRef;
	private String orderName;
	private int noOfOrders;
	private int createdBy;
	private Date createdDt;
	public Customer(){
	}
	
	public Customer(int orderRef, String orderName, int noOfOrders) {
		super();
		this.orderRef = orderRef;
		this.orderName = orderName;
		this.noOfOrders = noOfOrders;
	}

	public int getOrderRef() {
		return orderRef;
	}
	public void setOrderRef(int orderRef) {
		this.orderRef = orderRef;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getNoOfOrders() {
		return noOfOrders;
	}
	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	
}
