package com.kakaofriends.front.service;

import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.Migration;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 10.
 */
@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@Log
public class MigrationTest {
    @Autowired
    private MigrationService migrationService;

    @Test
    public void migration() {
        Migration migration = new Migration();
        migration.setTargetId("242646086");
        migration.setId(9999L);
        migrationService.migration(migration);
    }

    @Test
    public void test() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusSeconds(2);
        System.out.println("duration : " + Duration.between(endTime, startTime));
    }

}
