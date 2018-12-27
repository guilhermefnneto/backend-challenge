package com.invillia.acme.model;

import java.math.BigInteger;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="payment")
public class Payment {


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	private BigInteger credCardNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	
	@OneToOne
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
