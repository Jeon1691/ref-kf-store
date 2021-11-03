package com.kakaofriends.front.service.order.sub;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.core.common.configuration.persistence.type.DeliveryType;
import com.kakaofriends.core.common.configuration.persistence.type.OrderAccessType;
import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.domain.order.OrderSubData;
import com.kakaofriends.front.repository.order.OrderSubRepository;
import com.kakaofriends.front.service.order.constants.OrderSubType;
import com.kakaofriends.front.service.order.history.OrderSubHistoryService;
import com.kakaofriends.front.service.order.vo.OrderSub;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderSubServiceImpl : 주문상세에 대한 비즈니스 로직을 처리하는 서비스 구현체
 *
 * Author  april
 * Date    2017. 12. 26.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class OrderSubServiceImpl implements OrderSubService {
    private OrderSubRepository orderSubRepository;
    private OrderSubHistoryService orderSubHistoryService;

    @Override
    @Transactional(readOnly = true)
    public OrderSub get(long sequence) {
        log.info("#### sequence : {}", sequence);
        OrderSubData data = orderSubRepository.select(sequence);
        return this.converts(data);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderSub get(String orderNumber, int serial) {
        OrderSubData data = orderSubRepository.selectByOrderNumber(orderNumber, serial);
        return this.converts(data);
    }

    @Override
    public List<OrderSub> getList(String orderNumber) {
        OrderSub orderSub = new OrderSub();
        orderSub.setOrderNumber(orderNumber);
        return this.getList(orderSub);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderSub> getList(OrderSub orderSub) {
        log.info("#### PARAM : {}", orderSub);
        List<OrderSubData> orderSubDataList = orderSubRepository.selectList(this.converts(orderSub));
        List<OrderSub> orderSubList = new ArrayList<>();
        for (OrderSubData data : orderSubDataList) {
            orderSubList.add(this.converts(data));
        }
        return orderSubList;
    }

    @Override
    @Transactional
    public void addList(List<OrderSub> orderSubList) {
        for (OrderSub orderSub : orderSubList) {
            this.add(orderSub);
        }
        orderSubHistoryService.addList(orderSubList);
    }

    private void add(OrderSub orderSub) {
        log.info("#### PARAM : {}", orderSub);
        OrderSubData data = this.converts(orderSub);
        orderSubRepository.insert(data);
        orderSub.setSequence(data.getOsSeq());
    }

    private OrderSub converts(OrderSubData data) {
        OrderSub orderSub = new OrderSub();
        orderSub.setSequence(data.getOsSeq());
        orderSub.setOrderNumber(data.getOsOmNum());
        orderSub.setSerial(data.getOsSerial());
        orderSub.setPgTid(data.getOsPgtId());
        orderSub.setProductCode(data.getOsPrCode());
        orderSub.setSupplyCompanyCode(data.getOsScpCode());
        orderSub.setBusinessGroupCode(data.getOsBcpCode());
        orderSub.setBusinessPartCode(data.getOsBdpCode());
        orderSub.setMemberId(data.getOsOwnerId());
        orderSub.setMemberName(data.getOsOwnerName());
        orderSub.setCouponMoney(data.getOsCouponMoney());
        orderSub.setPointMoney(data.getOsPointMoney());
        orderSub.setOriginalMoney(data.getOsOriginalMoney());
        orderSub.setSaleMoney(data.getOsSaleMoney());
        orderSub.setTotalOriginalMoney(data.getOsTotOriginalMoney());
        orderSub.setTotalSaleMoney(data.getOsTotSaleMoney());
        orderSub.setKakaoMoney(data.getOsKakaoMoney());
        orderSub.setPaypalMoney(data.getOsPaypalMoney());
        orderSub.setAccountMoney(data.getOsAccountMoney());
        orderSub.setCardMoney(data.getOsCardMoney());
        orderSub.setEa(data.getOsEa());
        orderSub.setOutEa(data.getOsOutEa());
        orderSub.setInEa(data.getOsInEa());
        orderSub.setMemo(data.getOsMemo());
        orderSub.setDeliveryType(DeliveryType.get(data.getOsDeliType()));
        orderSub.setDeliveryMoneyUse(Usable.get(data.getOsDeliMoenyUse()));
        orderSub.setDeliveryMemo(data.getOsDeliMemo());
        orderSub.setDeliveryNumber(data.getOsDeliNum());
        orderSub.setDeliveryCompanySequence(data.getOsPccSeq());
        orderSub.setStatus(OrderStatusType.getOrderStatusType(data.getOsStatus()));
        orderSub.setSuperSerial(data.getOsEtc3());
        orderSub.setType(OrderSubType.get(data.getOsType()));
        orderSub.setUse(Usable.get(data.getOsUse()));
        orderSub.setModifiedId(data.getOsMoId());
        orderSub.setInsertedId(data.getOsInId());
        orderSub.setModifiedDate(data.getOsMoDate());
        orderSub.setInsertedDate(data.getOsInDate());
        orderSub.setAccessType(OrderAccessType.get(data.getOsAccessType()));
        orderSub.setDeliveryInOutType(DeliInOutType.get(data.getOsDeliInOutType()));
        orderSub.setCategorySequence(data.getOsCtSeq());
        orderSub.setCancelReason(data.getOsCancelReason());
        orderSub.setCustomMessage(data.getOsEtc7());
        orderSub.setExchangeRate(data.getOsExchangeRate());
        orderSub.setPaypalSaleId(data.getOsPaypalSaleId());
        orderSub.setCjFlag(data.getOsCjFlag());
        return orderSub;
    }

    private OrderSubData converts(OrderSub orderSub) {
        OrderSubData data = new OrderSubData();
        data.setOsSeq(orderSub.getSequence());
        data.setOsOmNum(orderSub.getOrderNumber());
        data.setOsSerial(orderSub.getSerial());
        data.setOsPgtId(orderSub.getPgTid());
        data.setOsPrCode(orderSub.getProductCode());
        data.setOsScpCode(orderSub.getSupplyCompanyCode());
        data.setOsBcpCode(orderSub.getBusinessGroupCode());
        data.setOsBdpCode(orderSub.getBusinessPartCode());
        data.setOsOwnerId(orderSub.getMemberId());
        data.setOsOwnerName(orderSub.getMemberName());
        data.setOsAccountMoney(orderSub.getAccountMoney());
        data.setOsCardMoney(orderSub.getCardMoney());
        data.setOsCouponMoney(orderSub.getCouponMoney());
        data.setOsPointMoney(orderSub.getPointMoney());
        data.setOsOriginalMoney(orderSub.getOriginalMoney());
        data.setOsSaleMoney(orderSub.getSaleMoney());
        data.setOsTotSaleMoney(orderSub.getTotalSaleMoney());
        data.setOsTotOriginalMoney(orderSub.getTotalOriginalMoney());
        data.setOsKakaoMoney(orderSub.getKakaoMoney());
        data.setOsPaypalMoney(orderSub.getPaypalMoney());
        data.setOsEa(orderSub.getEa());
        data.setOsOutEa(orderSub.getOutEa());
        data.setOsInEa(orderSub.getInEa());
        data.setOsMemo(orderSub.getMemo());
        data.setOsDeliType(orderSub.getDeliveryType() != null ? orderSub.getDeliveryType().getCode() : null);
        data.setOsDeliMoenyUse(orderSub.getDeliveryMoneyUse() != null ? orderSub.getDeliveryMoneyUse().getCode() : null);
        data.setOsDeliMemo(orderSub.getDeliveryMemo());
        data.setOsDeliNum(orderSub.getDeliveryNumber());
        data.setOsPccSeq(orderSub.getDeliveryCompanySequence());
        data.setOsStatus(orderSub.getStatus() != null ? orderSub.getStatus().getCode() : 0);
        data.setOsEtc3(orderSub.getSuperSerial());
        data.setOsType(orderSub.getType() != null ? orderSub.getType().getCode() : null);
        data.setOsUse(orderSub.getUse() != null ? orderSub.getUse().getCode() : null);
        data.setOsMoId(orderSub.getModifiedId());
        data.setOsInId(orderSub.getInsertedId());
        data.setOsAccessType(orderSub.getAccessType() != null ? orderSub.getAccessType().getCode() : null);
        data.setOsDeliInOutType(orderSub.getDeliveryInOutType() != null? orderSub.getDeliveryInOutType().getCode() : null);
        data.setOsCtSeq(orderSub.getCategorySequence());
        data.setOsCancelReason(orderSub.getCancelReason());
        data.setOsEtc7(orderSub.getCustomMessage());
        data.setOsExchangeRate(orderSub.getExchangeRate());
        data.setOsPaypalSaleId(orderSub.getPaypalSaleId());
        data.setOsCjFlag(orderSub.getCjFlag());
        return data;
    }
}