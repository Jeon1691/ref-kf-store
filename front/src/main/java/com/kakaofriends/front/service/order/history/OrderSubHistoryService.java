package com.kakaofriends.front.service.order.history;


import com.kakaofriends.front.service.order.history.vo.OrderSubHistory;
import com.kakaofriends.front.service.order.vo.OrderSub;

import java.util.List;

/**
 * OrderSubHistoryService
 *
 * Author  april
 * Date    2017. 12. 20.
 */
public interface OrderSubHistoryService {
    /**
     * 주문 이력 중 가장 마지막 정보를 조회한다.
     * @param orderNumber 주문 아이디
     * @param serial 주문 순차번호
     * @return 마지막 주문 이력
     */
    OrderSubHistory getLastHistory(String orderNumber, int serial);

    void addList(List<OrderSub> orderSubList);
}
