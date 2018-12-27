package com.invillia.acme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.invillia.acme.model.Store;

public interface StoreRepository extends CrudRepository<Store, Long> {

	List<Store> findByName(String name);
	
}
