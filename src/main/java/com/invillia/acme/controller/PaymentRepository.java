package com.invillia.acme.repository;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
