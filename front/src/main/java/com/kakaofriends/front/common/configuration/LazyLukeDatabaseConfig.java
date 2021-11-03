package com.kakaofriends.front.common.configuration;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = {"com.kakaofriends.front.repository"}, annotationClass = PrimaryMapper.class, sqlSessionTemplateRef = "sqlSessionTemplate")
@Profile(value = {"genius", "local", "development", "stage"})
public class LazyLukeDatabaseConfig extends DatabaseConfig {

	@Bean
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
}