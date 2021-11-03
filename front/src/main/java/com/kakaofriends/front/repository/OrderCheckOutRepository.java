package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.OrderAddress;
import com.kakaofriends.core.domain.OrderMain;
import com.kakaofriends.core.domain.OrderSub;
import com.kakaofriends.core.domain.OrderSubHistory;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@PrimaryMapper
@Repository
public interface OrderCheckOutRepository {

	void orderMainInsert(OrderMain orderMain);

	void orderSubInsert(@Param("orderSub") OrderSub orderSub);

	void orderAddressInsert(OrderAddress address);

	void orderSubHistoryInsert(OrderSubHistory orderSubHistory);

	int selectOrderList(@Param("orderNum") String orderNum);
}