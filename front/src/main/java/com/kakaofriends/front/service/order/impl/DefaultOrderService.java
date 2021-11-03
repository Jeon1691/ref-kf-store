package com.kakaofriends.front.service.order.impl;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.domain.payment.PaymentHistoryType;
import com.kakaofriends.front.service.giftcard.GiftCardService;
import com.kakaofriends.front.service.member.point.PointService;
import com.kakaofriends.front.service.order.address.OrderAddressService;
import com.kakaofriends.front.service.order.api.OrderService;
import com.kakaofriends.front.service.order.api.PreOrderService;
import com.kakaofriends.front.service.order.box.OrderBoxService;
import com.kakaofriends.front.service.order.main.OrderMainService;
import com.kakaofriends.front.service.order.sub.OrderSubService;
import com.kakaofriends.front.service.order.vo.*;
import com.kakaofriends.front.service.payment.PaymentHistoryService;
import com.kakaofriends.front.service.payment.accounting.AccountingService;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * DefaultOrderService : 주문에 관련된 비즈니스 로직을 처리하는 서비스
 *
 * Author  april
 * Date    2018. 1. 29.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultOrderService implements OrderService {
    private PreOrderService preOrderService;
    private OrderMainService orderMainService;
    private OrderSubService orderSubService;
    private OrderAddressService orderAddressService;
    private OrderBoxService orderBoxService;
    private PointService pointService;
    private GiftCardService giftCardService;

    private PaymentHistoryService paymentHistoryService;
    private AccountingService accountingService;

    @Override
    @Transactional(readOnly = true)
    public Order get(String orderNumber) {
        OrderMain orderMain = orderMainService.get(orderNumber);
        List<OrderSub> orderSubList = orderSubService.getList(orderNumber);
        OrderAddress orderAddress = orderAddressService.get(orderNumber);
        return new Order(orderMain, orderSubList, orderAddress);
    }

    @Transactional
    public void add(Order order) {
        log.info("#### PARAM = {}", order);
        OrderMain orderMain = order.getOrderMain();
        List<OrderSub> orderSubList = order.getOrderSubList();
        // add order data
        orderMainService.add(orderMain);
        orderSubService.addList(orderSubList);
        accountingService.addList(orderMain.getPayType(), PaymentAction.PAYMENT, orderSubList);

        orderAddressService.add(order.getOrderAddress());
        orderBoxService.add(orderMain, orderSubList);

        if (!FriendsUtil.isAnonymousUser()) {
            pointService.redeemPoint(orderMain);
            giftCardService.redeemGiftCard(FriendsUtil.getFriendsMember().getId(), orderMain.getOrderNumber(), order.getGiftCardCodeList());
        }
        paymentHistoryService.add(PaymentHistoryType.ORDER, PaymentAction.PAYMENT, orderMain);
    }

    @Override
    public void addByPreOrder(String orderNumber, String pgTid) {
        PreOrder preOrder = preOrderService.get(orderNumber);
        Order order = this.converts(preOrder);
        order.setTid(pgTid);
        this.add(order);
    }

    private Order converts(PreOrder preOrder) {
        OrderMain orderMain = this.converts(preOrder.getOrderMain());
        List<OrderSub> orderSubList = new ArrayList<>();
        for (PreOrderSub preOrderSub : preOrder.getOrderSubList()) {
            orderSubList.add(this.converts(preOrder.getOrderMain(), preOrderSub));
        }
        OrderAddress orderAddress = this.converts(preOrder.getOrderAddress());
        Order order = new Order(orderMain, orderSubList, orderAddress);
        order.setGiftCardCodeList(preOrder.getOrderMain().getCouponCodeList());
        return order;
    }

    private OrderMain converts(PreOrderMain preOrderMain) {
        OrderMain orderMain = new OrderMain();
        orderMain.setOrderNumber(preOrderMain.getOrderNumber());
        orderMain.setPgTid(preOrderMain.getPgTid());
        orderMain.setMemberId(preOrderMain.getMemberId());
        orderMain.setMemberName(preOrderMain.getMemberName());
        orderMain.setCouponMoney(preOrderMain.getCouponAmount());
        orderMain.setPointMoney(preOrderMain.getPointAmount());
        orderMain.setOrderMainPrice(preOrderMain.getPaymentType(), preOrderMain.getPaymentAmount());
        orderMain.setDeliveryMoney(preOrderMain.getDeliveryAmount());
        orderMain.setStatus(OrderStatusType.RECEIVING_ORDER);
        orderMain.setDeliveryType(preOrderMain.getDeliveryType());
        orderMain.setDeliveryMoneyUse(preOrderMain.getDeliveryMoneyUse());
        orderMain.setDeliveryMemo(preOrderMain.getDeliveryMemo());
        orderMain.setAccessType(preOrderMain.getAccessType());
        orderMain.setDeliveryInOutType(DeliInOutType.get(preOrderMain.getDomestic()));
        orderMain.setModifiedId(preOrderMain.getUpdateId());
        orderMain.setInsertedId(preOrderMain.getCreateId());
        orderMain.setModifiedDate(preOrderMain.getUpdateDate());
        orderMain.setInsertedDate(preOrderMain.getCreateDate());
        orderMain.setPayType(preOrderMain.getPaymentType());
        orderMain.setExchangeRate(preOrderMain.getExchangeRate());
        orderMain.setLanguage(preOrderMain.getLanguage());
        orderMain.setReferer(preOrderMain.getLanguage());
        return orderMain;
    }

    private OrderSub converts(PreOrderMain preOrderMain, PreOrderSub preOrderSub) {
        OrderSub  orderSub = new OrderSub();
        orderSub.setOrderNumber(preOrderMain.getOrderNumber());
        orderSub.setSerial(preOrderSub.getSerial());
        orderSub.setPgTid(preOrderSub.getPgTid());
        orderSub.setProductCode(preOrderSub.getProductCode());
        orderSub.setSupplyCompanyCode(KakaoFriendsConstants.SUPPLY_COMPANY_CODE);
        orderSub.setBusinessGroupCode(KakaoFriendsConstants.B2CGROUP);
        orderSub.setBusinessPartCode(KakaoFriendsConstants.B2CPART);
        orderSub.setMemberId(preOrderSub.getMemberId());
        orderSub.setMemberName(preOrderSub.getMemberName());
        orderSub.setCouponMoney(preOrderSub.getCouponAmount());
        orderSub.setPointMoney(preOrderSub.getPointAmount());
        orderSub.setOriginalMoney(preOrderSub.getProductAmount());
        orderSub.setSaleMoney(preOrderSub.getSalesAmount());
        orderSub.setTotalOriginalMoney(preOrderSub.getTotalProductAmount());
        orderSub.setTotalSaleMoney(preOrderSub.getTotalSalesAmount());
        orderSub.setOrderSubPrice(preOrderSub.getPaymentType(), preOrderSub.getPaymentAmount());
        orderSub.setEa(preOrderSub.getQuantity());
        orderSub.setOutEa(preOrderSub.getQuantity());
        orderSub.setInEa(0);
        orderSub.setMemo(preOrderSub.getMemo());
        orderSub.setDeliveryType(preOrderMain.getDeliveryType());
        orderSub.setDeliveryMoneyUse(preOrderMain.getDeliveryMoneyUse());
        orderSub.setDeliveryMemo(preOrderMain.getDeliveryMemo());
        orderSub.setDeliveryNumber(preOrderSub.getDeliveryNumber());
        orderSub.setStatus(OrderStatusType.RECEIVING_ORDER);
        orderSub.setType(preOrderSub.getOrderType());
        orderSub.setUse(Usable.get(preOrderSub.getUse()));
        orderSub.setModifiedId(preOrderSub.getUpdatedId());
        orderSub.setInsertedId(preOrderSub.getCreateId());
        orderSub.setModifiedDate(preOrderSub.getUpdateDate());
        orderSub.setInsertedDate(preOrderSub.getCreateDate());
        orderSub.setAccessType(preOrderMain.getAccessType());
        orderSub.setDeliveryInOutType(DeliInOutType.get(preOrderSub.getDomestic()));
        orderSub.setCategorySequence(preOrderSub.getCategorySequence());
        orderSub.setCancelReason(preOrderSub.getCancelReason());
        orderSub.setCustomMessage(preOrderSub.getCustomMessage());
        orderSub.setExchangeRate(preOrderSub.getExchangeRate());
        orderSub.setCjFlag(preOrderSub.getCjFlag());
        return orderSub;
    }

    private OrderAddress converts(PreOrderAddress preOrderAddress) {
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setOrderNumber(preOrderAddress.getOrderNumber());
        orderAddress.setCountry(preOrderAddress.getCountry());
        orderAddress.setName(preOrderAddress.getName());
        orderAddress.setAddress1(preOrderAddress.getAddress1());
        orderAddress.setAddress2(preOrderAddress.getAddress2());
        orderAddress.setAddress3(preOrderAddress.getAddress3());
        orderAddress.setDeliveryType(DeliInOutType.get(preOrderAddress.getDomestic()));
        orderAddress.setZipCode(preOrderAddress.getZipCode());
        orderAddress.setPhone(preOrderAddress.getPhone());
        orderAddress.setEmail(preOrderAddress.getEmail());
        orderAddress.setDeliveryMemo(preOrderAddress.getDeliveryMemo());
        orderAddress.setBuyerName(preOrderAddress.getBuyerName());
        orderAddress.setBuyerPhone(preOrderAddress.getBuyerPhone());
        orderAddress.setBuyerEmail(preOrderAddress.getBuyerEmail());
        orderAddress.setBuyerCountry(preOrderAddress.getBuyerCountry());
        orderAddress.setType(preOrderAddress.getAddressType());
        orderAddress.setUse(Usable.get(preOrderAddress.getUse()));
        orderAddress.setModifiedId(preOrderAddress.getUpdateId());
        orderAddress.setInsertedId(preOrderAddress.getCreateId());
        orderAddress.setModifiedDate(preOrderAddress.getUpdateDate());
        orderAddress.setInsertedDate(preOrderAddress.getCreateDate());
        return orderAddress;
    }
}