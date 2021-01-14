package com.jschool.reha.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Hibernate Spring configuration
 * @author Dmitry Sorokin
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jschool.reha")
public class HibernateConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.jschool.reha.entity");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    /**
     * Data source connection properties
     *
     * @return dataSource
     */
    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        } catch (PropertyVetoException e) {
            //TODO Add logging and handling
            throw new RuntimeException(e);
        }

        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/reha?useUnicode=true&serverTimezone=UTC");
        dataSource.setUser("rehauser");
        dataSource.setPassword("user1234");

        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(5);
        dataSource.setMaxPoolSize(30);
        dataSource.setMaxIdleTime(3000);

        return dataSource;
    }

    /**
     * Transaction manager bean
     *
     * @return transactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getNativeEntityManagerFactory());
        return transactionManager;
    }

    /**
     * Setting up hibernate properties
     *
     * @return hibernateProperties
     */
    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty(
                "hibernate.hbm2ddl.auto", "validate");
        properties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty(
                "show_sql","true");
        properties.setProperty("hibernate.c3p0.initialPoolSize","5");
        properties.setProperty("hibernate.c3p0.min_size","5");
        properties.setProperty("hibernate.c3p0.max_size","30");
        properties.setProperty("hibernate.c3p0.timeout","2000");
        properties.setProperty("show_sql","true");

        return properties;
    }
}
