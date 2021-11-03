package com.kakaofriends.front.service.payment;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.domain.payment.PaymentHistory;
import com.kakaofriends.front.domain.payment.PaymentHistoryType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * TestPaymentHistoryService
 *
 * Author  april
 * Date    2017. 12. 18.
 */
@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class TestPaymentHistoryService {
    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @Test
    public void add() {
        PaymentHistory data = new PaymentHistory();
        data.setMemberId(1234l);
        data.setOrderId("ORDERID12340");
        data.setPaymentMethod(PayType.KAKAOPAY);
        data.setType(PaymentHistoryType.ORDER);
        data.setAction(PaymentAction.PAYMENT);
        data.setCurrency(Currency.KRW);
        data.setPaymentAmount(30000f);
        data.setShippingAmount(2500f);
        paymentHistoryService.add(data);
    }

    @Test
    public void exceptionTest() {
        RestTemplate restTemplate = new RestTemplate();

        Object object = restTemplate.getForObject("http://172.28.120.71:8080/exception/test", Object.class);
        System.out.println("object = " + object);
    }
}
