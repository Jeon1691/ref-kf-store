package com.kakaofriends.front.service;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.controller.login.vo.UserCreateRequestVO;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.Provision;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;

@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@Log
public class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProvisionService provisionService;
    @Test
    public void insert() throws Exception {
        UserCreateRequestVO member = new UserCreateRequestVO();
        member.setEmail("dev.snoopy@gmail.com");
        member.setPassword("wonhwa");
        member.setCountry("kr");
        member.setGender("M");
        member.setProviderId("kakao");
        member.setProviderUserId("jlaskjfdlaksjf");
        memberService.insert(member);
    }

    @Test
    public void get() throws Exception {
        Member member = new Member();
        member.setEmail("dev.snoopy@gmail.com");
        member.setPassword("wonhwa");
        member.setBarcode("barcord");
        member.setBarcodeUrl("http://localhost:8080");
        member.setBirthday("4444");
        member.setBirthyear("4444");
        member.setCountry("kr");
        member.setGender("M");
        memberService.get(member);
        log.info(String.valueOf(memberService.get(member)));

    }

    @Test
    public void update() throws Exception {

        UserCreateRequestVO member = new UserCreateRequestVO()
                .setId(13L)
                .setPassword(passwordEncoder.encode("1234565"))
                .setPhoneAuth(true)
                .setEmailAuth(false);
        memberService.update(member);
    }

    @Test
    public void provisionService() throws Exception {
        Provision provision = new Provision();
        provision.setCountry("kr");
        log.info(String.valueOf(provisionService.getLatestProvision(provision)));
    }

    @Test
    public void dateTest() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = now.plusMonths(6).minusDays(1);
        System.out.println(now.toString());
        System.out.println(end.toString());
    }
}