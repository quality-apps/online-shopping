package com.siri.shoppingbackend.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.siri.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshopping";
    private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private final static String DATABASE_USERNAME = "root";
    private final static String DATABASE_PASSWORD = "root";

    @Bean
    public DataSource getDataSource() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);

        return dataSource;
    }

    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionFactoryBuilder.addProperties(getHibernateProperties());
        sessionFactoryBuilder.scanPackages("com.siri.shoppingbackend.dto");
        return sessionFactoryBuilder.buildSessionFactory();
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

    //All the hibernate properties will be returned
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", DATABASE_DIALECT);
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        return properties;
    }


}
