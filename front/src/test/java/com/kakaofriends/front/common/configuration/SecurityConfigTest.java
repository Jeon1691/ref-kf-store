package com.kakaofriends.front.common.configuration;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@Log
public class SecurityConfigTest {

    @Autowired
    PasswordEncoder encoder;


    @Test
    public void passwordEncoder() throws Exception {

        String orginPassword = "xptmxm";


        String encodedPassword = encoder.encode(orginPassword);

        Assert.assertNotNull("Encode : test", encoder.encode(orginPassword));
        System.out.println(encodedPassword);

        // pw : $2a$10$2g5aCpSGrPTUdoXuZuiyFezUVhoKYVEqC9ARaT4G9esqAwN1IsWjm
        // id : layla.rae@kakaocorp.com
        Assert.assertEquals(true, encoder.matches(orginPassword, encodedPassword));

    }

}