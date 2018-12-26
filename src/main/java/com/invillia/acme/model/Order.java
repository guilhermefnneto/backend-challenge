package com.invillia.acme.model;

import java.util.Calendar;
import java.util.List;

public class Order {

	
	private String address;
	private Calendar confirmation;
	private String status;
	private Store store;
	private List<OrderItem> orderItems;
	
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Calendar getConfirmation() {
		return confirmation;
	}
	
	public void setConfirmation(Calendar confirmation) {
		this.confirmation = confirmation;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Store getStore() {
		return store;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
