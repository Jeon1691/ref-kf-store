package com.kakaofriends.front.common.configuration;

import com.kakaofriends.front.common.configuration.interceptor.KakaoTalkUserAgentInterceptor;
import com.kakaofriends.front.common.configuration.interceptor.LocaleChangeInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.util.UrlPathHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.kakaofriends.front" )
public class ServletConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private static final String[] CLASSPATH_RESOURCE_HANDLER = { "/resources/**" };
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "/resources/" };
    private static final String CLASSPATH_ROBOTS_HANDLER = "/robots.txt";
    private static final String CLASSPATH_ROBOTS_LOCATIONS = "/robots.txt";
    private static final Integer CACHE_PERIOD = 60 * 60 * 24 * 365;
    private static final int MAX_UP_LOAD_SIZE = 100 * 1024 * 1024;
    private static final int MAX_IN_MEMORY_SIZE = 100 * 1024 * 1024;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void configurePathMatch( PathMatchConfigurer configurer ) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent( false );
        configurer.setUrlPathHelper( urlPathHelper );
    }

    @Override
    public void configureContentNegotiation( ContentNegotiationConfigurer configurer ) {
        configurer.useJaf( true )
            .favorPathExtension( true )
            .favorParameter( false )
            .ignoreAcceptHeader( false );
        configurer.defaultContentType( new MediaType( MediaType.APPLICATION_JSON_UTF8, StandardCharsets.UTF_8 ) );
    }

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addRedirectViewController( "/", "/kr/index/lang" );
        registry.addRedirectViewController( "/", "/kr/index" );
        //registry.addViewController("/kr/member/welcome");

    }

    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry ) {
        registry.addResourceHandler( CLASSPATH_RESOURCE_HANDLER )
            .addResourceLocations( CLASSPATH_RESOURCE_LOCATIONS )
            .setCachePeriod( CACHE_PERIOD )
            .resourceChain( true );

        // 검색엔진에서 긁어 갈 수 있도록 robots.txt 설정. 2018.04.25 Breeze
        registry.addResourceHandler( CLASSPATH_ROBOTS_HANDLER )
            .addResourceLocations( CLASSPATH_ROBOTS_LOCATIONS )
            .setCachePeriod( CACHE_PERIOD )
            .resourceChain( true );
    }

    @Override
    public void addInterceptors( InterceptorRegistry registry ) {
//		registry.addInterceptor(webContentInterceptor()).addPathPatterns(new String[]{"/resources/**"});
//		registry.addInterceptor(friendsInterceptor()).addPathPatterns(new String[]{
//				"/**/shipping/orderCancel",
//				"/**/shipping/purchaseFinalized",
//				"/**/shipping/returnRequestAll",
//				"/**/shipping/returnRequest",
//				"/**/shipping/exchangeRequest",
//				"/**/shipping/address/change"
//		});
//		registry.addInterceptor(kakaoInterceptor()).addPathPatterns(new String[]{
//				"/kr/**",
//				"/en/**"
//		});
        registry.addInterceptor( kakaoTalkUserAgentInterceptor() )
            .addPathPatterns( "/**" )
            .excludePathPatterns(
                "/favicon.ico",
                "/resources/**",
                "/common/**",
                "/**/policy/**",
                "/**/error/**",
                "/kr/signup",
                "/en/signup",
                "/signup/kakao",
                "/signin",
                "/auth/**",
                "/member/welcome",
                "/order/**",
                "/orderadddeli/**",
                "/kr/*/inimobile/*",
                "/en/*/inimobile/*",
                "/kr/*/paypal/*",
                "/en/*/paypal/*",
                "/logout"
            );
        registry.addInterceptor( localeChangeInterceptor() );
        registry.addInterceptor( new DeviceResolverHandlerInterceptor() );
    }

/*	@Bean
	public WebContentInterceptor webContentInterceptor() {
		WebContentInterceptor interceptor = new WebContentInterceptor();
		return interceptor;
	}*/

	/*@Bean
	public FriendsInterceptor friendsInterceptor() {
		FriendsInterceptor interceptor = new FriendsInterceptor();
		return interceptor;
	}*/

//	@Bean
//	public KakaoInterceptor kakaoInterceptor() {
//		KakaoInterceptor interceptor = new KakaoInterceptor();
//		return interceptor;
//	}

    @Bean
    public KakaoTalkUserAgentInterceptor kakaoTalkUserAgentInterceptor() {
        return new KakaoTalkUserAgentInterceptor();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        return interceptor;
    }

    @Bean
    public MultipartResolver filterMultipartResolver() throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize( MAX_UP_LOAD_SIZE );
        multipartResolver.setMaxInMemorySize( MAX_IN_MEMORY_SIZE );
        multipartResolver.setDefaultEncoding( "UTF-8" );
        return multipartResolver;
    }

    @Bean( name = "localeResolver" )
    public LocaleResolver sessionLocaleResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();

        localeResolver.setDefaultLocale( Locale.KOREA );
        return localeResolver;
    }

    @Bean
    public BeanNameViewResolver beanNameViewResolver() {
        BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
        beanNameViewResolver.setOrder( 1 );
        return beanNameViewResolver;
    }

    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setOrder( 0 );
        urlBasedViewResolver.setViewClass( TilesView.class );
        return urlBasedViewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions( "/WEB-INF/config/tiles/tilesConfig.xml" );
        tilesConfigurer.setCheckRefresh( true );
        return tilesConfigurer;
    }
}
