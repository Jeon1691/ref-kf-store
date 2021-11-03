package com.kakaofriends.front.service.order.history;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.front.domain.order.OrderSubHistoryData;
import com.kakaofriends.front.repository.OrderSubHistoryRepository;
import com.kakaofriends.front.service.order.constants.OrderSubType;
import com.kakaofriends.front.service.order.history.vo.OrderSubHistory;
import com.kakaofriends.front.service.order.vo.OrderSub;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * OrderSubHistoryServiceImpl
 *
 * Author  april
 * Date    2017. 12. 20.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class OrderSubHistoryServiceImpl implements OrderSubHistoryService {
    private OrderSubHistoryRepository orderSubHistoryRepository;

    @Override
    @Transactional(readOnly = true)
    public OrderSubHistory getLastHistory(String orderNumber, int serial) {
        OrderSubHistoryData data = orderSubHistoryRepository.selectMaxDate(orderNumber, serial);
        return this.converts(data);
    }

    @Override
    @Transactional
    public void addList(List<OrderSub> orderSubList) {
        for (OrderSub orderSub : orderSubList) {
            this.add(orderSub);
        }
    }

    private void add(OrderSubHistory history) {
        log.info("#### PARAM : {}", history);
        orderSubHistoryRepository.insert(this.converts(history));
    }

    private void add(OrderSub orderSub) {
        if (orderSub.getType().equals(OrderSubType.ORDER)) {
            OrderSubHistory history = new OrderSubHistory();
            history.setOrderNumber(orderSub.getOrderNumber());
            history.setSerial(orderSub.getSerial());
            history.setMemo(orderSub.getStatus().getName());
            history.setStatus(orderSub.getStatus());
            history.setInsertedId(orderSub.getMemberId());
            history.setModifiedId(orderSub.getMemberId());
            this.add(history);
        }
    }

    private OrderSubHistory converts(OrderSubHistoryData data) {
        OrderSubHistory history = new OrderSubHistory();
        history.setSequence(data.getOshSeq());
        history.setOrderNumber(data.getOshOmNum());
        history.setSerial(data.getOshOsSerial());
        history.setMemo(data.getOshMemo());
        history.setStatus(OrderStatusType.getOrderStatusType(data.getOshOsStatus()));
        history.setModifiedId(data.getOshMoId());
        history.setInsertedId(data.getOshInId());
        history.setModifiedDate(data.getOshMoDate());
        history.setInsertedDate(data.getOshInDate());
        return history;
    }

    private OrderSubHistoryData converts(OrderSubHistory history) {
        OrderSubHistoryData data = new OrderSubHistoryData();
        data.setOshSeq(history.getSequence());
        data.setOshOmNum(history.getOrderNumber());
        data.setOshOsSerial(history.getSerial());
        data.setOshMemo(history.getMemo());
        data.setOshOsStatus(history.getStatus().getCode());
        data.setOshMoId(history.getModifiedId());
        data.setOshInId(history.getInsertedId());
        data.setOshMoDate(history.getModifiedDate());
        data.setOshInDate(history.getInsertedDate());
        return data;
    }

}
