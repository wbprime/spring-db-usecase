package me.wbprime.springdbusecase.springdatajpa.java.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Class: AppContext
 * Date: 2016/04/13 18:33
 *
 * @author Elvis Wang [bo.wang35@renren-inc.com]
 */
@Configuration
@Import({MvcContext.class, ServicesContext.class, PersistenceContext.class})
public class AppContext {
}
