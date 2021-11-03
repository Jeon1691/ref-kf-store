package com.kakaofriends.front.repository.order;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.order.OrderMainData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * OrderMainRepository : 주문 주 정보에 대한 DB와 통신하는 레퍼지토리
 *
 * Author  april
 * Date    2018. 1. 28.
 */
@PrimaryMapper
@Repository
public interface OrderMainRepository {
    OrderMainData select(@Param("orderNumber") String orderNumber);

    void insert(OrderMainData orderMainData);
}