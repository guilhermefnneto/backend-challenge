package com.invillia.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.OrderItem;
import com.invillia.acme.repository.OrderItemRepository;


@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public boolean create(OrderItem pOrderItem) {
		return orderItemRepository.save(pOrderItem) != null;
	}

	
}
