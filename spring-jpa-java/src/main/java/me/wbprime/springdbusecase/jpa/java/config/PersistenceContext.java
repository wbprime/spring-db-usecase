package me.wbprime.springdbusecase.jpa.java.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
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
@ComponentScan(basePackages = {"me.wbprime.springdbusecase.jpa.java.dao.impl" })
public class PersistenceContext {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("init.sql")
            .build();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws Exception {
        final LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();

        bean.setPackagesToScan(
            new String [] {"me.wbprime.springdbusecase.jpa.java.models"}
        );

        bean.setDataSource(dataSource());

        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        bean.setJpaProperties(properties);

        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        bean.afterPropertiesSet();
        return bean.getObject();
    }

    @Bean
    public JpaTransactionManager transactionManager() throws Exception {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory());

        return transactionManager;
    }
}
