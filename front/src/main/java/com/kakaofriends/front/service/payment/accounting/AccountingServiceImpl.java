package com.kakaofriends.front.service.payment.accounting;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.domain.payment.accounting.AccountingData;
import com.kakaofriends.front.repository.payment.accounting.AccountingRepository;
import com.kakaofriends.front.service.order.constants.OrderSubType;
import com.kakaofriends.front.service.order.vo.OrderSub;
import com.kakaofriends.front.service.payment.accounting.vo.Accounting;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * AccountingServiceImpl
 *
 * Author  april
 * Date    2018. 3. 9.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class AccountingServiceImpl implements AccountingService {
    private AccountingRepository accountingRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Accounting> getList(String orderNumber, PaymentAction paymentAction) {
        log.info("#### PARAM : orderNumber = {}, paymentAction = {}", orderNumber, paymentAction);
        Accounting searchCondition = new Accounting();
        searchCondition.setOrderNumber(orderNumber);
        searchCondition.setPaymentAction(paymentAction);
        return this.getList(searchCondition);
    }

    private List<Accounting> getList(Accounting accounting) {
        List<Accounting> accountingList = new ArrayList<>();
        List<AccountingData> dataList = accountingRepository.selectList(this.converts(accounting));
        for (AccountingData data : dataList) {
            accountingList.add(this.converts(data));
        }
        return accountingList;
    }

    @Override
    @Transactional
    public void add(Accounting accounting) {
        log.info("#### PARAM : {}", accounting);
        accountingRepository.insert(this.converts(accounting));
    }

    @Override
    @Transactional
    public void addList(PayType payType, PaymentAction paymentAction, List<OrderSub> orderSubList) {
        for (OrderSub orderSub : orderSubList) {
            this.add(payType, paymentAction, orderSub);
        }
    }

    private void add(PayType payType, PaymentAction paymentAction, OrderSub orderSub) {
        Accounting accounting = this.getAccounting(payType, paymentAction, orderSub);
        this.add(accounting);
    }

    private AccountingData converts(Accounting accounting) {
        AccountingData data = new AccountingData();
        data.setId(accounting.getId());
        data.setOrderId(accounting.getOrderNumber());
        data.setOrderSerial(accounting.getOrderSerial());
        data.setDomestic(accounting.getDomestic());
        data.setAction(accounting.getPaymentAction() != null ? accounting.getPaymentAction().name() : null);
        data.setProductId(accounting.getProductCode());
        data.setQuantity(accounting.getQuantity());
        data.setPrice(accounting.getPrice());
        data.setCurrency(accounting.getCurrency() != null ? accounting.getCurrency().name() : null);
        data.setPaymentMethod(accounting.getPaymentMethod() != null ? accounting.getPaymentMethod().name() : null);
        data.setPaymentAmount(accounting.getPaymentAmount());
        data.setPoint(accounting.getPointAmount());
        data.setCoupon(accounting.getCouponAmount());
        data.setCreateDate(accounting.getCreateDate());
        return data;
    }

    private Accounting converts(AccountingData data) {
        Accounting accounting = new Accounting();
        accounting.setId(data.getId());
        accounting.setOrderNumber(data.getOrderId());
        accounting.setOrderSerial(data.getOrderSerial());
        accounting.setDomestic(data.getDomestic());
        accounting.setPaymentAction(PaymentAction.valueOf(data.getAction()));
        accounting.setProductCode(data.getProductId());
        accounting.setQuantity(data.getQuantity());
        accounting.setPrice(data.getPrice());
        accounting.setCurrency(Currency.getCurrency(data.getCurrency()));
        accounting.setPaymentMethod(PayType.valueOf(data.getPaymentMethod()));
        accounting.setPaymentAmount(data.getPaymentAmount());
        accounting.setPointAmount(data.getPoint());
        accounting.setCouponAmount(data.getCoupon());
        accounting.setCreateDate(data.getCreateDate());
        return accounting;
    }

    private Accounting getAccounting(PayType payType, PaymentAction paymentAction, OrderSub orderSub) {
        Accounting accounting = new Accounting();
        accounting.setOrderNumber(orderSub.getOrderNumber());
        accounting.setOrderSerial(orderSub.getSerial());
        accounting.setDomestic(orderSub.getDeliveryInOutType().isDomestic());
        accounting.setPaymentAction(paymentAction);
        if (orderSub.getType().equals(OrderSubType.ORDER)) {
            accounting.setProductCode(orderSub.getProductCode());
        } else {
            accounting.setProductCode(Accounting.DELIVERY_PRODUCT_CODE);
        }
        accounting.setQuantity(orderSub.getEa());
        accounting.setPrice(orderSub.getSaleMoney());
        accounting.setCurrency(Currency.getCurrency(payType));
        accounting.setPaymentMethod(payType);
        accounting.setPointAmount(orderSub.getPointMoney());
        accounting.setCouponAmount(orderSub.getCouponMoney());
        switch (payType) {
            case PAYPAL:
                BigDecimal krw = orderSub.getPaypalMoney();
                BigDecimal rate = orderSub.getExchangeRate();
                accounting.setPaymentAmount(ExchangeRateComponent.exchange(krw, rate));
                break;
            case ONLY_CARD:
                accounting.setPaymentAmount(orderSub.getCardMoney());
                break;
            case KAKAOPAY:
            case KAKAOPAY_V2:
                accounting.setPaymentAmount(orderSub.getKakaoMoney());
                break;
        }
        return accounting;
    }
}