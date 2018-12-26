package com.invillia.acme.model;

import java.math.BigInteger;
import java.util.Calendar;

public class Payment {

	
	private PaymentStatus status;
	private BigInteger credCardNumber;
	private Calendar date;
	private Order order;
	
	
	public PaymentStatus getStatus() {
		return status;
	}
	
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
	public BigInteger getCredCardNumber() {
		return credCardNumber;
	}
	
	public void setCredCardNumber(BigInteger credCardNumber) {
		this.credCardNumber = credCardNumber;
	}
	
	public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
