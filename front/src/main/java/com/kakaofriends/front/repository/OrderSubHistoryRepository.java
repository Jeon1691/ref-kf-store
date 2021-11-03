package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.order.OrderSubHistoryData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * OrderSubHistoryRepository
 *
 * Author  april
 * Date    2017. 12. 20.
 */
@PrimaryMapper
@Repository
public interface OrderSubHistoryRepository {
    /**
     * 주문 이력중 가장 최근의 이력을 한 건 조회한다.
     *
     * @param oderId 주문 아이디
     * @param serial 주문 순차번호
     * @return 최신 주문 이력
     */
    OrderSubHistoryData selectMaxDate(@Param("orderId") String oderId, @Param("serial") int serial);

    /**
     * 주문 이력을 갱신한다 (임시 CS용)
     * @param data 주문 이력 데이타
     */
    void update(@Param("history") OrderSubHistoryData data);

    void insert(@Param("history") OrderSubHistoryData data);
}
