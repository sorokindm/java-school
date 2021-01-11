package com.jschool.reha.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
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
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "validate");
        hibernateProperties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty(
                "show_sql","true");
        hibernateProperties.setProperty("hibernate.c3p0.initialPoolSize","5");
        hibernateProperties.setProperty("hibernate.c3p0.min_size","5");
        hibernateProperties.setProperty("hibernate.c3p0.max_size","30");
        hibernateProperties.setProperty("hibernate.c3p0.timeout","2000");
        hibernateProperties.setProperty("show_sql","true");

        return hibernateProperties;
    }
}
