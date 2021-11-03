package com.kakaofriends.front.domain.kims;

import com.kakaofriends.front.common.configuration.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class WakeUpDeveloperTest {

    @Autowired
    WakeUpDeveloper wakeUpDeveloper;
    @Test
    public void sendWakeUpMessageToDeveloper() throws Exception {

        wakeUpDeveloper.sendWakeUpMessageToDeveloper();
    }
}