package com.kakaofriends.front.service.order.main;

import com.kakaofriends.core.common.configuration.persistence.type.*;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.domain.order.OrderMainData;
import com.kakaofriends.front.repository.order.OrderMainRepository;
import com.kakaofriends.front.service.order.vo.OrderMain;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrderMainService : 주문 주 정보 관련 내용을 처리하는 서비스
 *
 * Author  april
 * Date    2018. 1. 29.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class OrderMainServiceImpl implements OrderMainService {
    private OrderMainRepository orderMainRepository;

    /**
     * 주문 주요 정보를 조회한다.
     *
     * @param orderNumber 주문 번호
     * @return 주문 주요 정보
     */
    @Override
    @Transactional(readOnly = true)
    public OrderMain get(String orderNumber) {
        OrderMainData data = orderMainRepository.select(orderNumber);
        return this.converts(data);
    }

    /**
     * 주문 주 정보를 등록한다.
     *
     * @param orderMain 주문 주 정보
     */
    @Override
    @Transactional
    public void add(OrderMain orderMain) {
        log.info("#### PARAM : {}", orderMain);
        orderMainRepository.insert(this.converts(orderMain));
    }

    private OrderMainData converts(OrderMain orderMain) {
        OrderMainData data = new OrderMainData();
        data.setOmSeq(orderMain.getSequence());
        data.setOmNum(orderMain.getOrderNumber());
        data.setOmPgtId(orderMain.getPgTid());
        data.setOmOwnerId(orderMain.getMemberId());
        data.setOmOwnerName(orderMain.getMemberName());
        data.setOmAccountMoney(orderMain.getAccountMoney());
        data.setOmCouponMoney(orderMain.getCouponMoney());
        data.setOmCardMoney(orderMain.getCardMoney());
        data.setOmDeliveryMoney(orderMain.getDeliveryMoney());
        data.setOmPointMoney(orderMain.getPointMoney());
        data.setOmKakaoMoney(orderMain.getKakaoMoney());
        data.setOmPaypalMoney(orderMain.getPaypalMoney());
        data.setOmStatus(orderMain.getStatus().getCode());
        data.setOmDeliType(orderMain.getDeliveryType().getCode());
        data.setOmDeliMoenyUse(orderMain.getDeliveryMoneyUse().getCode());
        data.setOmDeliMemo(orderMain.getDeliveryMemo());
        data.setOmAccessType(orderMain.getAccessType().getCode());
        data.setOmDeliInOutType(orderMain.getDeliveryInOutType().getCode());
        data.setOmMoId(orderMain.getModifiedId());
        data.setOmInId(orderMain.getInsertedId());
        data.setOmMoDate(orderMain.getModifiedDate());
        data.setOmInDate(orderMain.getInsertedDate());
        data.setOmPayType(orderMain.getPayType().getCode());
        data.setOmExchangeRate(orderMain.getExchangeRate());
        data.setOmPaypalSaleId(orderMain.getPaypalSaleId());
        data.setLanguage(orderMain.getLanguage());
        data.setReferer(orderMain.getLanguage());
        return data;
    }

    private OrderMain converts(OrderMainData data) {
        OrderMain orderMain = new OrderMain();
        orderMain.setSequence(data.getOmSeq());
        orderMain.setOrderNumber(data.getOmNum());
        orderMain.setPgTid(data.getOmPgtId());
        orderMain.setMemberId(data.getOmOwnerId());
        orderMain.setMemberName(data.getOmOwnerName());
        orderMain.setCouponMoney(data.getOmCouponMoney());
        orderMain.setPointMoney(data.getOmPointMoney());
        orderMain.setAccountMoney(data.getOmAccountMoney());
        orderMain.setCardMoney(data.getOmCardMoney());
        orderMain.setKakaoMoney(data.getOmKakaoMoney());
        orderMain.setPaypalMoney(data.getOmPaypalMoney());
        orderMain.setDeliveryMoney(data.getOmDeliveryMoney());
        orderMain.setStatus(OrderStatusType.getOrderStatusType(data.getOmStatus()));
        orderMain.setDeliveryType(DeliveryType.get(data.getOmDeliType()));
        orderMain.setDeliveryMoneyUse(Usable.get(data.getOmDeliMoenyUse()));
        orderMain.setDeliveryMemo(data.getOmDeliMemo());
        orderMain.setAccessType(OrderAccessType.get(data.getOmAccessType()));
        orderMain.setDeliveryInOutType(DeliInOutType.get(data.getOmDeliInOutType()));
        orderMain.setModifiedId(data.getOmMoId());
        orderMain.setInsertedId(data.getOmInId());
        orderMain.setModifiedDate(data.getOmMoDate());
        orderMain.setInsertedDate(data.getOmInDate());
        orderMain.setPayType(PayType.get(data.getOmPayType()));
        orderMain.setExchangeRate(data.getOmExchangeRate());
        orderMain.setPaypalSaleId(data.getOmPaypalSaleId());
        orderMain.setLanguage(data.getLanguage());
        orderMain.setReferer(data.getReferer());
        return orderMain;
    }
}
