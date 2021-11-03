package com.kakaofriends.front.service;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.ProvisionAgreement;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 1.
 */

@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@Log
public class ProvisionAgreementServiceImplTest {

    @Autowired
    private ProvisionAgreementService provisionAgreementService;


    @Test
    public void getNeedAgreementProvision() throws Exception {
        ProvisionAgreement provisionAgreement = new ProvisionAgreement();
        provisionAgreement.setMemberId(13L);
        log.info("" + provisionAgreementService.getNeedAgreementProvision(provisionAgreement));
    }

    @Test
    public void agreeProvision() throws Exception {
        ArrayList<ProvisionAgreement> provisionAgreementList = new ArrayList<ProvisionAgreement>();
        ProvisionAgreement temp = new ProvisionAgreement();
        temp.setMemberId(13L);
        temp.setProvisionCountry("kr");
        temp.setProvisionCode("USED");
        temp.setProvisionVersion(1);
        temp.setAgreement(true);
        provisionAgreementList.add(temp);
        temp = new ProvisionAgreement();

        temp.setMemberId(13L);
        temp.setProvisionCountry("kr");
        temp.setProvisionCode("COLLECTION");
        temp.setProvisionVersion(1);
        temp.setAgreement(true);
        provisionAgreementList.add(temp);
        temp = new ProvisionAgreement();

        temp.setMemberId(13L);
        temp.setProvisionCountry("kr");
        temp.setProvisionCode("EMAIL");
        temp.setProvisionVersion(1);
        temp.setAgreement(true);
        provisionAgreementList.add(temp);
        provisionAgreementService.agreeProvision(provisionAgreementList);
    }

}