package com.kakaofriends.front.repository.order;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.order.OrderAddressData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * OrderAddressRepository : 주문 배송지에 대한 데이터 통신을 하는 레퍼지토리
 *
 * Author  april
 * Date    2018. 1. 29.
 */
@PrimaryMapper
@Repository
public interface OrderAddressRepository {
    OrderAddressData select(@Param("orderNumber") String orderNumber);

    void insert(@Param("address") OrderAddressData data);
}
