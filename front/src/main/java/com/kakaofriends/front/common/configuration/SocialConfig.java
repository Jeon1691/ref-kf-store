package com.kakaofriends.front.common.configuration;

import com.kakaofriends.front.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.kakao.connect.KakaoConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import javax.sql.DataSource;

@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private MemberService memberService;

    @Autowired
    private void setMemberService( MemberService memberService ) {
        this.memberService = memberService;
    }

    @Override
    public void addConnectionFactories( ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment ) {
        connectionFactoryConfigurer.addConnectionFactory(
            new KakaoConnectionFactory(
                environment.getProperty( "spring.social.kakao.app.id" ),
                environment.getProperty( "spring.social.kakao.app.url.authorize" ),
                environment.getProperty( "spring.social.kakao.app.url.api" ),
                memberService
            )
        );
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository( ConnectionFactoryLocator connectionFactoryLocator ) {
        return new JdbcUsersConnectionRepository( dataSource, connectionFactoryLocator, Encryptors.noOpText() );
    }

    @Bean
    public ConnectController connectController( ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository ) {
        return new ConnectController( connectionFactoryLocator, connectionRepository );
    }

    @Bean
    public ProviderSignInUtils providerSignInUtils( ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository usersConnectionRepository ) {
        return new ProviderSignInUtils( connectionFactoryLocator, usersConnectionRepository );
    }

}