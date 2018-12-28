package com.invillia.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.PaymentRepository;


@Service
public class PaymentService {

	
	@Autowired
	private PaymentRepository paymentRepository;
	

	public boolean create(Payment pPayment) {
		return paymentRepository.save(pPayment) != null;
	}
	
}
