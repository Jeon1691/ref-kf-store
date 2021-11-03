package com.kakaofriends.front.service;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.service.giftcard.GiftCardService;
import com.kakaofriends.front.service.giftcard.history.GiftCardHistoryService;
import com.kakaofriends.front.service.giftcard.vo.GiftCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

;

/**
 * TestPaymentHistoryService
 *
 * Author  april
 * Date    2018. 01. 22.
 */
@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class TestGiftCardService {
    @Autowired
    private GiftCardService giftCardService;
    @Autowired
    private GiftCardHistoryService giftCardHistoryService;

    @Test
    public void get() {
        GiftCard giftCard = giftCardService.getWithMaster("4NsP-TN8W-4n78-BvQi");
        System.out.println(giftCard);
    }

    @Test
    public void addHistory() {
        GiftCard giftCard = giftCardService.getWithMaster("4NsP-TN8W-4n78-BvQi");
        giftCard.setMemberId(9999l);
        giftCardHistoryService.add(giftCard);
    }
}
