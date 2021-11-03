package com.kakaofriends.front.service.order;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.service.order.constants.PaymentStatus;
import com.kakaofriends.front.service.order.main.PreOrderMainService;
import com.kakaofriends.front.service.order.vo.PreOrderMain;
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
public class TestPreOrderMainService {

    @Autowired
    private PreOrderMainService preOrderMainService;

    @Test
    public void select() {
        PreOrderMain orderMain = preOrderMainService.get("K1803211609360884");
        System.out.println(orderMain);
        orderMain.setPaymentStatus(PaymentStatus.COMPLETE);
//        preOrderMainService.edit(orderMain);
    }

}
