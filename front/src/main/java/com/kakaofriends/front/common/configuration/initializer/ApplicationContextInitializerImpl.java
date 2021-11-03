package com.kakaofriends.front.common.configuration.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.StandardEnvironment;

@Slf4j
@Order(value = 0)
public class ApplicationContextInitializerImpl implements ApplicationContextInitializer {

	private static final String SPRING_PROFILES_ACTIVE_PROPERTY = "spring.profiles.active";

	@Override
	public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
		configurableApplicationContext.getEnvironment().setActiveProfiles(new StandardEnvironment().getProperty(SPRING_PROFILES_ACTIVE_PROPERTY));
	}
}
