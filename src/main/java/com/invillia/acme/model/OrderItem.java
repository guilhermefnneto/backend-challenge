package com.invillia.acme.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity(name="sorderitem")
public class OrderItem {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private BigDecimal unitPrice;
	private BigInteger quantity;
	
	@ManyToOne
	private Order order;
	
	
	public OrderItem() { }
	
	public OrderItem(String description, BigDecimal unitPrice, BigInteger quantity) {
		setDescription(description);
		setUnitPrice(unitPrice);
		setQuantity(quantity);
	}
	
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public BigInteger getQuantity() {
		return quantity;
	}
	
	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
