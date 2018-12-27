package com.invillia.acme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.Store;
import com.invillia.acme.repository.StoreRepository;


@Service
public class StoreService {
	

	@Autowired
	private StoreRepository storeRepository;
	
	public boolean create(Store pStore) {
		return storeRepository.save(pStore) != null;
	}
	
	public Store read(Store pStore) {
		Optional<Store> optional = storeRepository.findById(pStore.getId());
		return optional.get();
	}
	
	public List<Store> readByName(String name) {
		return storeRepository.findByName(name);
	}
	
	public boolean update(Long id, Store pStore) {
		Store rStore = read(new Store(id));
		if (rStore != null) {
			rStore.setName(pStore.getName());
			rStore.setAddress(pStore.getAddress());
			return storeRepository.save(rStore) != null;
		} else return false;
	}
	
}
