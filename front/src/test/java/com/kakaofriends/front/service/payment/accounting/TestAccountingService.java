package com.kakaofriends.front.service.payment.accounting;

import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.service.payment.accounting.vo.Accounting;
import com.kakaofriends.front.service.sales.KfoSalesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.List;

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
public class TestAccountingService {
    @Autowired
    private AccountingService accountingService;
    @Autowired
    private KfoSalesService salesService;

    @Test
    public void add() {
        Accounting accounting = new Accounting();
        accounting.setOrderNumber("K0987654321");
        accounting.setOrderSerial(1);
        accounting.setDomestic(Boolean.TRUE);
        accounting.setPaymentAction(PaymentAction.PAYMENT);
        accounting.setProductCode("PRCODEAPRIL");
        accounting.setQuantity(3);
        accounting.setPrice(BigDecimal.valueOf(1000));
        accounting.setCurrency(Currency.KRW);
        accounting.setPaymentMethod(PayType.KAKAOPAY_V2);
        accounting.setPaymentAmount(BigDecimal.valueOf(3000));
        accounting.setPointAmount(BigDecimal.ZERO);
        accounting.setCouponAmount(BigDecimal.ZERO);
        accountingService.add(accounting);
        salesService.add(accounting);
    }

    @Test
    public void select() {
        List<Accounting> accountingList = accountingService.getList("K1803221101161432", PaymentAction.PAYMENT);
        System.out.println(accountingList);
    }
}
