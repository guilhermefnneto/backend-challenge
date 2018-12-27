package com.invillia.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.Order;
import com.invillia.acme.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public boolean create(Order pOrder) {
		return orderRepository.save(pOrder) != null;
	}
	
	public Order read(Order pOrder) {
		return orderRepository.findById(pOrder.getId()).get();
	}
		
}
