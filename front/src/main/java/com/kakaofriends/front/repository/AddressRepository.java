package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.Address;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@PrimaryMapper
@Repository
public interface AddressRepository {

	Long findMaxSeq(HashMap<String, String> map);

	int insertAddress(Address address);
}