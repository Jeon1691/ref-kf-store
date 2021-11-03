package com.kakaofriends.front.service;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.service.stat.StatService;
import com.kakaofriends.front.utils.DateUtil;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * StatServiceTest
 * <p>
 * Author  layla
 * Date    2018. 5. 16.
 */
@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@Log
public class StatServiceTest {
    @Autowired
    private StatService statService;

    @Test
    public void insert() {
        String sParam = "naver";
        statService.insert(sParam);


        String ssParam = "daum";
        statService.insert(ssParam);
    }

    @Test
    public void test() {
        DateUtil dateUtil = new DateUtil();
        System.out.println(dateUtil.getDateyyyyMMdd());
        System.out.println(dateUtil.getDateHH());
    }
}
