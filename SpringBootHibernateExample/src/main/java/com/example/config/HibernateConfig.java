package com.example.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan({"com.example"})
public class HibernateConfig {

	@Value("${database.driver}")
	String driverName;
	@Value("${database.url}")
	String databaseUrl;
	@Value("${database.user}")
	String databaseUser;
	@Value("${database.password}")
	String databasePassword;
	@Value("${hibernate.dialect}")
	String hibernateDialect;
	@Value("${hibernate.show_sql}")
	String hibernateShowSql;
	@Value("${hibernate.hbm2ddl.auto}")
	String hibernateHbm2ddlAuto;
	
	
	

	//to load the hibenrate properties and return it
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", hibernateShowSql);
		properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
		return properties;
	}
	
	//#1. First Create the Data source using the above DB details like URL, username, password
	
	@Bean
	@Qualifier("myDataSource") //using qualifier, in case we have multiple data sources for multiple DBs, to identify which data source to use
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(databaseUser);
		dataSource.setPassword(databasePassword);
		return dataSource;
	}
	
	//#2 Create Session Factory out of Data Source and Hibernate Properties
	
	@Bean
	@Qualifier("mySessionFactory")
	public LocalSessionFactoryBean getSessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		sessionFactory.setPackagesToScan("com.example");
		
		return sessionFactory;
		
		
	}
	
	@Bean
	@Qualifier("myTransactionManager")
	public HibernateTransactionManager transactionManager(@Qualifier(value = "mySessionFactory") SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory);		
		return transactionManager;
	}
	
	
	@Bean(name = "myHibernateTemplate")
	public HibernateTemplate getHibernateTemplate(@Qualifier(value = "mySessionFactory") SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}
	
	@Bean
	@Qualifier("myJdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {		
		return new JdbcTemplate(getDataSource());
	}
	
}
