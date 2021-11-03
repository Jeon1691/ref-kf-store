package com.kakaofriends.front.service.order;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.service.order.address.PreOrderAddressService;
import com.kakaofriends.front.service.order.vo.PreOrderAddress;
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
public class TestPreOrderAddressService {

    @Autowired
    private PreOrderAddressService preOrderAddressService;

    @Test
    public void select() {
        PreOrderAddress orderAddress = preOrderAddressService.get("K1803201848331863");
        System.out.println(orderAddress);
    }

}
