package com.invillia.acme.repository;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
