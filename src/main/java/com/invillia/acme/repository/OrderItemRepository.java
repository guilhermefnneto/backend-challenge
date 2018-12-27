package com.invillia.acme.repository;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.model.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
