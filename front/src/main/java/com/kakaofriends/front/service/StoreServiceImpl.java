package com.kakaofriends.front.service;

import com.kakaofriends.core.domain.Store;
import com.kakaofriends.front.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	public List<Store> findAll() {
		return storeRepository.findAll();
	}
}