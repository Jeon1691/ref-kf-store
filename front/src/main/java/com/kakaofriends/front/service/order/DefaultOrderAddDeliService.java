package com.kakaofriends.front.service.order;

import com.kakaofriends.core.domain.OrderAddDeli;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.domain.payment.PaymentHistory;
import com.kakaofriends.front.domain.payment.PaymentHistoryType;
import com.kakaofriends.front.service.payment.PaymentHistoryService;
import com.kakaofriends.front.service.payment.accounting.AccountingService;
import com.kakaofriends.front.service.payment.accounting.vo.Accounting;
import com.kakaofriends.front.service.payment.vo.PaymentExecution;
import com.kakaofriends.front.service.sales.KfoSalesService;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMember;

/**
 * Created by eunduck on 2018. 1. 31..
 */
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultOrderAddDeliService {

    private OrderAddDeliService orderAddDeliService;
    private PaymentHistoryService paymentHistoryService;
    private AccountingService accountingService;
    private KfoSalesService salesService;

    @Transactional
    public void edit(PaymentExecution paymentExecution, OrderAddDeli addDeli) {
        OrderAddDeli orderAddDeli = getOrderAddDeli(paymentExecution, addDeli);
        PaymentHistory history = getPaymentHistory(addDeli);
        Accounting accounting = getAccounting(addDeli);

        orderAddDeliService.updateOrderAddDeliByPayment(orderAddDeli);
        orderAddDeliService.updateLeftProduct(orderAddDeli);
        paymentHistoryService.add(history);
        // ERP
        accountingService.add(accounting);
        salesService.add(accounting);
    }

    private Accounting getAccounting(OrderAddDeli addDeli) {
        // FIXME : 해외 회수비 처리시 페이팔 환전 처리 및 Domestic 구분 변경
        Accounting accounting = new Accounting();
        accounting.setOrderNumber(addDeli.getOdOdNum());
        accounting.setOrderSerial(1);
        accounting.setDomestic(Boolean.TRUE);
        accounting.setPaymentAction(PaymentAction.PAYMENT);
        accounting.setProductCode(Accounting.RETURN_DELIVERY_PRODUCT_CODE);
        accounting.setQuantity(1);
        accounting.setPrice(BigDecimal.valueOf(addDeli.getOdReqMoney()));
        accounting.setCurrency(Currency.getCurrency(addDeli.getOdPayType()));
        accounting.setPaymentMethod(addDeli.getOdPayType());
        switch (addDeli.getOdPayType()) {
            case PAYPAL:
//                페이팔 환전처리
//                accounting.setPaymentAmount();
                break;
            case ONLY_CARD:
            case KAKAOPAY_V2:
            case KAKAOPAY:
                accounting.setPaymentAmount(BigDecimal.valueOf(addDeli.getOdReqMoney()));
                break;
        }
        return accounting;
    }

    /**
     * INICIS, INICIS_MOBILE : ONLY_CARD
     * KAKAOPAY : KAKAOPAY_V2
     * @param paymentExecution
     * @param addDeli
     * @return
     */
    private OrderAddDeli getOrderAddDeli(PaymentExecution paymentExecution, OrderAddDeli addDeli) {
        OrderAddDeli orderAddDeli = new OrderAddDeli();
        orderAddDeli.setOdMoId(FriendsUtil.getFriendsMemberId());
        orderAddDeli.setOdPayType(addDeli.getOdPayType());
        orderAddDeli.setOdOdNum(addDeli.getOdOdNum());
        orderAddDeli.setOdOmNum(addDeli.getOdOmNum());
        orderAddDeli.setOdOsSeq(addDeli.getOdOsSeq());
        orderAddDeli.setOdOdPgTid(paymentExecution.getTid());
        orderAddDeli.setOdCreditCardNum(paymentExecution.getCardCode());
        orderAddDeli.setOdAccountMoney(0);

        switch (orderAddDeli.getOdPayType()) {
            case ONLY_CARD:
                orderAddDeli.setOdCardMoney(addDeli.getOdReqMoney());
                orderAddDeli.setOdKakaoMoney(0);
                break;
            case KAKAOPAY_V2:
                orderAddDeli.setOdCardMoney(0);
                orderAddDeli.setOdKakaoMoney(addDeli.getOdReqMoney());
                break;
        }
        return orderAddDeli;
    }

    private PaymentHistory getPaymentHistory(OrderAddDeli orderAddDeli){
        PaymentHistory history = new PaymentHistory();
        if(FriendsUtil.isAnonymousUser()) {
            history.setMemberId(PaymentHistory.NON_MEMBER);
        } else {
            history.setMemberId(getFriendsMember().getId());
        }
        history.setOrderId(orderAddDeli.getOdOdNum());
        history.setType(PaymentHistoryType.ORDER);
        history.setAction(PaymentAction.PAYMENT);
        history.setCurrency(Currency.KRW);
        history.setPaymentMethod(orderAddDeli.getOdPayType());
        history.setShippingAmount(orderAddDeli.getOdReqMoney());
        return history;
    }
}
