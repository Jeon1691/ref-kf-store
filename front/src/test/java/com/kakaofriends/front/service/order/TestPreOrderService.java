package com.kakaofriends.front.service.order;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.service.order.api.PreOrderService;
import com.kakaofriends.front.service.order.constants.PaymentStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * TestOrderSubHistoryService
 *
 * Author  april
 * Date    2017. 12. 20.
 */
@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class TestPreOrderService {

    @Autowired
    private PreOrderService preOrderService;

    @Test
    public void status() {
        preOrderService.editPaymentStatus("K1803211609360884", PaymentStatus.COMPLETE);
        System.out.println("end");
    }

}
