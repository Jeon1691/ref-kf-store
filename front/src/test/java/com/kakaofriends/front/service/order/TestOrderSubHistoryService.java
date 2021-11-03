package com.kakaofriends.front.service.order;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.service.order.history.OrderSubHistoryService;
import com.kakaofriends.front.service.order.history.vo.OrderSubHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;

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
public class TestOrderSubHistoryService {
    @Autowired
    private OrderSubHistoryService orderSubHistoryService;


    @Autowired
    private ExchangeRateComponent exchangeRateComponent;

    @Test
    public void select() {
        OrderSubHistory history = orderSubHistoryService.getLastHistory("O20151017184756102", 2);
        System.out.println(history);
    }

    @Test
    public void exchange() {

        BigDecimal price = exchangeRateComponent.exchangeToUSD(new BigDecimal(2000));
        double price2 = exchangeRateComponent.exchangeToUSD(2000);
        System.out.println(price);
        System.out.println(price2);
    }
}
