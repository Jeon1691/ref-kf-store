package com.kakaofriends.front.service.order;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.service.order.constants.PaymentStatus;
import com.kakaofriends.front.service.order.sub.PreOrderSubService;
import com.kakaofriends.front.service.order.vo.PreOrderSub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

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
public class TestPreOrderSubService {

    @Autowired
    private PreOrderSubService preOrderSubService;

    @Test
    public void select() {
        List<PreOrderSub> orderSubList = preOrderSubService.getList("K1803201848073186");
        System.out.println(orderSubList);

        for (PreOrderSub preOrderSub : orderSubList) {
            preOrderSub.setPaymentStatus(PaymentStatus.COMPLETE);
            preOrderSubService.edit(preOrderSub);
        }
    }

}
