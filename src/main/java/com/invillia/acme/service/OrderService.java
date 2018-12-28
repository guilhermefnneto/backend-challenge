package com.invillia.acme.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.OrderStatus;
import com.invillia.acme.model.PaymentStatus;
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
	
	public boolean refund(Order pOrder) {
		Calendar confirmation = pOrder.getConfirmation();
		Calendar now = Calendar.getInstance();
		
		long millisConfirmation = confirmation.getTimeInMillis();
		long millisNow = now.getTimeInMillis();
		
		int days = (int)((millisNow - millisConfirmation)/ (24*60*60*1000)); // hora em minutos em segundos em milésimos
		
		if (days <= 10 && pOrder.getPayment() != null && PaymentStatus.CONCLUSED.equals(pOrder.getPayment().getStatus())) {
			pOrder.setStatus(OrderStatus.REFUND);
			return orderRepository.save(pOrder) != null;
		}
		
		return false;
	}
		
}
