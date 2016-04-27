package me.wbprime.springdbusecase.hibernate.java.config;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Class: PersistenceContext
 * Date: 2016/04/13 18:05
 *
 * @author Elvis Wang [bo.wang35@renren-inc.com]
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"me.wbprime.springdbusecase.hibernate.java.dao.impl" })
public class PersistenceContext {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("init.sql")
            .build();
    }

    @Bean
    public SessionFactory sessionFactory() throws Exception {
        final LocalSessionFactoryBean bean = new LocalSessionFactoryBean();

        bean.setPackagesToScan(
            new String [] {"me.wbprime.springdbusecase.hibernate.java.models"}
        );

        bean.setDataSource(dataSource());

        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        bean.setHibernateProperties(properties);

        bean.afterPropertiesSet();
        return bean.getObject();
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws Exception {
        final HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactory());

        return transactionManager;
    }
}
