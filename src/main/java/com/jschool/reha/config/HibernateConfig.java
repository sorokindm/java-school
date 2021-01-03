package com.jschool.reha.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Hibernate Spring configuration
 *
 * @author Dmitry Sorokin
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jschool.reha")
public class HibernateConfig {

    /**
     * Hibernate session factory bean
     *
     * @return sessionFactory
     */
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.jschool.reha.crud");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    /**
     * Data source connection properties
     *
     * @return dataSource
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/reha?useUnicode=true&serverTimezone=UTC");
        dataSource.setUsername("rehauser");
        dataSource.setPassword("user1234");

        return dataSource;
    }

    /**
     * Transaction manager bean
     *
     * @return transactionManager
     */
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    /**
     * Setting up hibernate properties
     *
     * @return hibernateProperties
     */
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "validate");
        hibernateProperties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty(
                "show_sql","true");
//        hibernateProperties.setProperty(
//                "current_session_context_class", "thread");

        return hibernateProperties;
    }
}
