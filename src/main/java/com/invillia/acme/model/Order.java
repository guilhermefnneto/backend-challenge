package com.invillia.acme.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="sorder")
public class Order {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String address;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar confirmation;
	
	private String status;
	
	@ManyToOne
	private Store store;
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> orderitem;
	
	@OneToOne
	private Payment payment;
	
	
	
	public Long getId() {
		return id;
	}
	
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

	public List<OrderItem> getOrderItem() {
		return orderitem;
	}

	public void setOrderItem(List<OrderItem> orderitem) {
		this.orderitem = orderitem;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
