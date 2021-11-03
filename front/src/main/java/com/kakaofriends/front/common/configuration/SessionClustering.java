package com.kakaofriends.front.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
@Order(1)
public class SessionClustering extends AbstractHttpSessionApplicationInitializer{

    @Resource
    private Environment environment;



    @Bean
    public LettuceConnectionFactory connectionFactory() {
        LettuceConnectionFactory factory = new LettuceConnectionFactory();
        factory.setHostName(environment.getProperty("redis.host"));
        if (!StringUtils.isEmpty(environment.getProperty("redis.password"))) {
            factory.setPassword(environment.getProperty("redis.password"));
        }
        return factory;
    }

    /*@Bean public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setHostName( "10.201.2.191" );
        cf.setPort( 6379 );
        cf.afterPropertiesSet();
        return cf;
    }*/

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}
