package com.kakaofriends.front.repository;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.domain.payment.PaymentHistoryData;
import com.kakaofriends.front.domain.payment.PaymentHistoryType;
import com.kakaofriends.front.repository.payment.PaymentHistoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * TestPaymentHistoryRepository
 *
 * Author  april
 * Date    2017. 12. 18.
 */
@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class TestPaymentHistoryRepository {
    @Autowired
    private PaymentHistoryRepository repository;

    @Test
    public void insert() {
        PaymentHistoryData data = new PaymentHistoryData();
        data.setMemberId(123l);
        data.setOrderId("ORDERID123");
        data.setPaymentMethod(PayType.ONLY_CARD.name());
        data.setType(PaymentHistoryType.ORDER.name());
        data.setAction(PaymentAction.PAYMENT.name());
        data.setCurrency(Currency.USD.name());
        data.setPaymentAmount(3.2f);
        data.setShippingAmount(1.5f);
        repository.insert(data);
    }
}
