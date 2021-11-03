package com.kakaofriends.front.service.payment;

import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.domain.payment.PaymentHistory;
import com.kakaofriends.front.domain.payment.PaymentHistoryData;
import com.kakaofriends.front.domain.payment.PaymentHistoryType;
import com.kakaofriends.front.repository.payment.PaymentHistoryRepository;
import com.kakaofriends.front.service.order.vo.OrderMain;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * PaymentHistoryServiceImpl :  결제 이력을 처리하는 서비스
 *
 * Author  april
 * Date    2017. 12. 18.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class PaymentHistoryServiceImpl implements PaymentHistoryService {
    private PaymentHistoryRepository paymentHistoryRepository;

    @Override
    @Transactional
    public void add(PaymentHistory history) {
        log.info("#### PARAM : {}", history);
        try {
            PaymentHistoryData data = this.converts(history);
            paymentHistoryRepository.insert(data);
        } catch (Exception e) {
            log.error("### EXCEPTION CAUGHT DURING add PaymentHistory = {}", history);
            log.error("### EXCEPTION CAUGHT DURING add PaymentHistory = {}", e);
        }
    }

    @Override
    @Transactional
    public void add(PaymentHistoryType type, PaymentAction paymentAction, OrderMain orderMain) {
        this.add(this.converts(type, paymentAction, orderMain));
    }

    private PaymentHistoryData converts(PaymentHistory history) {
        PaymentHistoryData data = new PaymentHistoryData();
        data.setId(history.getId());
        data.setMemberId(history.getMemberId());
        data.setOrderId(history.getOrderId());
        data.setType(history.getType().name());
        data.setAction(history.getAction().name());
        data.setPaymentMethod(history.getPaymentMethod().name());
        data.setCurrency(history.getCurrency().name());
        data.setPaymentAmount(history.getPaymentAmount());
        data.setShippingAmount(history.getShippingAmount());
        data.setCreatedDate(history.getCreatedDate());
        return data;
    }

    private PaymentHistory converts(PaymentHistoryType type, PaymentAction paymentAction, OrderMain orderMain) {
        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setType(type);
        paymentHistory.setMemberId(orderMain.getMemberId());
        paymentHistory.setOrderId(orderMain.getOrderNumber());
        paymentHistory.setPaymentMethod(orderMain.getPayType());
        paymentHistory.setCurrency(Currency.getCurrency(orderMain.getPayType()));
        paymentHistory.setAction(paymentAction);

        BigDecimal deliveryPrice = orderMain.getDeliveryMoney();
        paymentHistory.setPaymentAmount(deliveryPrice.floatValue());
        switch (orderMain.getPayType()) {
            case PAYPAL:
                BigDecimal paypalMoney = orderMain.getPaypalMoney().subtract(deliveryPrice);
                BigDecimal exchangeRate = orderMain.getExchangeRate();
                paymentHistory.setPaymentAmount(ExchangeRateComponent.exchangeToFloat(paypalMoney, exchangeRate));
                paymentHistory.setShippingAmount(ExchangeRateComponent.exchangeToFloat(deliveryPrice, exchangeRate));
                break;
            case KAKAOPAY:
            case KAKAOPAY_V2:
                BigDecimal kakaoMoney = orderMain.getKakaoMoney().subtract(deliveryPrice);
                paymentHistory.setPaymentAmount(kakaoMoney.floatValue());
                paymentHistory.setShippingAmount(deliveryPrice.floatValue());
                break;
            case ONLY_CARD:
                BigDecimal cardMoney = orderMain.getCardMoney().subtract(deliveryPrice);
                paymentHistory.setPaymentAmount(cardMoney.floatValue());
                paymentHistory.setShippingAmount(deliveryPrice.floatValue());
                break;
        }
        return paymentHistory;
    }
}
