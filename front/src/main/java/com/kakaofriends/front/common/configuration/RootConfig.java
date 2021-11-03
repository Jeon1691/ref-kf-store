package com.kakaofriends.front.common.configuration;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.kakaofriends.core.common.pagination.DefaultPaginationManager;
import com.kakaofriends.core.common.pagination.DefaultPaginationRenderer;
import com.kakaofriends.core.common.pagination.PaginationManager;
import com.kakaofriends.core.common.pagination.PathPaginationRenderer;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.jackson.JsonNodeValueReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.HTTP_WAITING_TIME;

@Slf4j
@Configuration
@ComponentScan(basePackages = {"com.kakaofriends.front"})
@PropertySource("classpath:config/application-${spring.profiles.active:local}.xml")
public class RootConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Resource geoIP() {
		return new FileSystemResourceLoader().getResource("classpath:/location/GeoIP.dat");
	}

	@Bean
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(HTTP_WAITING_TIME);
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		messageConverters.add(new SourceHttpMessageConverter());
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		RestTemplate restTemplate = new RestTemplate(factory);
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}

	@Bean(name = "restTemplateNoHttpMessageConverter")
	public RestTemplate restTemplateNoHttpMessageConverter() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(HTTP_WAITING_TIME);
		RestTemplate restTemplate = new RestTemplate(factory);
		return restTemplate;
	}

	@Bean
	public JavaMailSender mailSender(@Value("${mail.smtp.url}") String mailHost) {
		Properties prop = new Properties();
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", "false");
		prop.put("mail.smtp.starttls.enable", "false");
		prop.put("mail.debug", "false");
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setDefaultEncoding("UTF-8");
		javaMailSender.setHost(mailHost);
		javaMailSender.setJavaMailProperties(prop);
		return javaMailSender;
	}

	@Bean
	public SimpleMailMessage simpleMailMessage(@Value("${mail.smtp.sender.addr}") String from) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(from);
		return simpleMailMessage;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		reloadableResourceBundleMessageSource.setBasenames(new String[]{"classpath:messages/message_common"});
		reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
		reloadableResourceBundleMessageSource.setCacheSeconds(5);
		return reloadableResourceBundleMessageSource;
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().addValueReader(new JsonNodeValueReader());
		mapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
		return mapper;
	}

	@Bean
	public PaginationManager paginationManager() {
		DefaultPaginationManager defaultPaginationManager = new DefaultPaginationManager();
		defaultPaginationManager.setRendererType(ImmutableMap.of("Default", new DefaultPaginationRenderer(), "Path", new PathPaginationRenderer()));
		return defaultPaginationManager;
	}

	@Bean
	public TemplateEngine emailTemplateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(emailTemplateResolver());
		engine.setEnableSpringELCompiler(true);
		engine.setAdditionalDialects(Sets.newHashSet(new Java8TimeDialect()));
		return engine;
	}

	private ITemplateResolver emailTemplateResolver() {
		ClassLoaderTemplateResolver iTemplateResolver = new ClassLoaderTemplateResolver();
		iTemplateResolver.setOrder(1);
		iTemplateResolver.setPrefix("/mail/");
		iTemplateResolver.setSuffix(".html");
		iTemplateResolver.setCacheable(false);
		iTemplateResolver.setCheckExistence(true);
		iTemplateResolver.setCharacterEncoding("UTF-8");
		iTemplateResolver.setTemplateMode(TemplateMode.HTML);
		return iTemplateResolver;
	}
}