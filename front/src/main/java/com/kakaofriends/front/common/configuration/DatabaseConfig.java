package com.kakaofriends.front.common.configuration;

import com.kakaofriends.core.common.configuration.persistence.type.*;
import com.kakaofriends.core.common.configuration.persistence.typeHandler.*;
import com.kakaofriends.core.domain.Friend;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.common.configuration.persistence.type.CategoryGroup;
import com.kakaofriends.front.common.configuration.persistence.typeHandler.CategoryGroupTypeHandler;
import com.kakaofriends.front.domain.PromotionExpansion;
import com.kakaofriends.front.domain.WishlistDto;
import com.kakaofriends.front.domain.basket.BasketExpansion;
import com.kakaofriends.front.domain.order.OrderSheetExpansion;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.*;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.apache.ibatis.type.LocalDateTypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;

@Slf4j
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = {"com.kakaofriends.front.repository"}, annotationClass = PrimaryMapper.class, sqlSessionTemplateRef = "sqlSessionTemplate")
//@Profile({"production"})
public class DatabaseConfig {

	private static final String MYBATIS_MAPPER_FILE_PATH = "classpath:/mybatis/mapper/**/**.xml";

	@Value("${jdbc.driver}")
	String jdbcDriver;

	@Value("${jdbc.url}")
	String jdbcUrl;

	@Value("${jdbc.user}")
	String username;

	@Value("${jdbc.password}")
	String password;

	@Value("${jdbc.connectionTestQuery}")
	String testQuery;

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}

	@Bean(name = "dataSource", destroyMethod = "close")
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(jdbcDriver);
		hikariConfig.setJdbcUrl(jdbcUrl);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);

		hikariConfig.setMaximumPoolSize(100);
		hikariConfig.setMinimumIdle(50);
		hikariConfig.setMaxLifetime(86400000);
		hikariConfig.setPoolName("friendsDB-Pool");

		hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
		hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");

		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}

	@Bean
	@Primary
	public SqlSessionFactory sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setConfigurationProperties(properties());
		sessionFactory.setMapperLocations(applicationContext.getResources(MYBATIS_MAPPER_FILE_PATH));
		sessionFactory.setTypeAliases(typeAliases());
		sessionFactory.setTypeAliasesPackage("com.kakaofriends.core.domain");
		sessionFactory.setTypeHandlersPackage("com.kakaofriends.front.common.configuration.persistence.typeHandler");
		// 카멜케이스 설정 추가(하고 싶었으나.. 기존 소스들 고쳐야 할 곳이 너무 많아서 일단 주석). 2017.11.02 Breeze
//		sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		sessionFactory.setTypeHandlers(typeHandlers());

		SqlSessionFactory factory = sessionFactory.getObject();
		factory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
		return factory;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactoryOracle) throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryOracle);
		return sqlSessionTemplate;
	}

	@Bean
	public SqlSession sqlSession(SqlSessionFactory sqlSessionFactoryOracle) throws Exception {
		SqlSession sqlSession = sqlSessionTemplate(sqlSessionFactoryOracle);
		return sqlSession;
	}

	protected Properties properties() {
		Properties properties = new Properties();
		properties.setProperty("defaultExecutorType", "BATCH");
		properties.setProperty("cacheEnabled", "true");
		properties.setProperty("useGeneratedKeys", "true");
		properties.setProperty("jdbcTypeForNull", "NULL");
		return properties;
	}

	protected Class<?>[] typeAliases() {
		return new Class<?>[]
		{
			LocalDateTime.class, LocalDate.class, Instant.class,
			DateTypeHandler.class, LocalDateTypeHandler.class, LocalDateTimeTypeHandler.class, InstantTypeHandler.class,
			Timestamp.class, Time.class,
			Friend.class, ProductExpansion.class, BasketExpansion.class, CategoryGroup.class, CategoryGroupTypeHandler.class, BannerType.class, BannerTypeHandler.class,
			ProductDisplayType.class, ProductDisplayTypeHandler.class, BusinessDayType.class, BusinessDayTypeHandler.class,
			PayType.class, PayTypeHandler.class, OrderStatusType.class, OrderStatusTypeHandler.class, OrderAccessType.class, OrderAccessTypeHandler.class,
			WishlistDto.WishlistExpansion.class, OrderSheetExpansion.class, DeliInOutType.class, DeliInOutTypeHandler.class, BoardReplyType.class, BoardReplyTypeHandler.class,
			PromotionExpansion.class
		};
	}

	protected TypeHandler[] typeHandlers() {
		return new TypeHandler[]
		{
			new DateTypeHandler(), new LocalDateTypeHandler(), new LocalDateTimeTypeHandler(), new InstantTypeHandler(),
			new BusinessDayTypeHandler(), new CategoryGroupTypeHandler(), new BannerTypeHandler(), new ProductDisplayTypeHandler(), new BusinessDayTypeHandler(),
			new OrderStatusTypeHandler(), new PayTypeHandler(), new DeliInOutTypeHandler(), new OrderAccessTypeHandler(), new BoardReplyTypeHandler()
		};
	}
}
