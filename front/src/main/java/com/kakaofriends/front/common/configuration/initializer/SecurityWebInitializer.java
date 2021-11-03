package com.kakaofriends.front.common.configuration.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Slf4j
@Order(value = 2)
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {

}
