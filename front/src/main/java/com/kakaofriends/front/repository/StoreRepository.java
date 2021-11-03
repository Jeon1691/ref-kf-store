package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.Store;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface StoreRepository {

	List<Store> findAll();

}