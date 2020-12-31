package com.practise.api.config;


import java.util.HashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Profile("dev")
@PropertySource({ "classpath:application.yml" })

@EnableJpaRepositories(basePackages = "com.practise.api.repositories", entityManagerFactoryRef = "h2EntityManagerFactory", transactionManagerRef = "h2TransactionManager")
public class H2DbConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory() {

		//logger.info("**** Loading Dev profile tiersEntityManagerFactory *****");

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		em.setDataSource(h2DataSource());
		em.setPackagesToScan(new String[] { "com.practise.api" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		//properties.put("jpa.show_sql", env.getProperty("spring.jpa.properties.show-sql"));
		properties.put("hibernate.dialect", env.getProperty("h2-datasource.platform"));
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean
	public DataSource h2DataSource() {
		//logger.info("**** Loading Dev  profile tiersDataSource *****");

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("h2-datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("h2-datasource.url"));
		dataSource.setUsername(env.getProperty("h2-datasource.username"));
		dataSource.setPassword(env.getProperty("h2-datasource.password"));

		return dataSource;
	}

	@Bean()
	@Qualifier("h2JdbcTemplate")
	public NamedParameterJdbcTemplate tiersJdbcTemplate() {
		return new NamedParameterJdbcTemplate(h2DataSource());
	}

	@Bean
	public PlatformTransactionManager h2TransactionManager() {

		//logger.info("**** Loading Dev  profile tiersTransactionManager *****");

		JpaTransactionManager tiersTransactionManager = new JpaTransactionManager();
		tiersTransactionManager.setEntityManagerFactory(h2EntityManagerFactory().getObject());
		return tiersTransactionManager;
	}
}
