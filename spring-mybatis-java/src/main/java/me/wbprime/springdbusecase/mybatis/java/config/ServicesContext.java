package me.wbprime.springdbusecase.mybatis.java.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class: ServicesContext
 * Date: 2016/04/11 23:14
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
@Configuration
@ComponentScan(basePackages = {"me.wbprime.springdbusecase.mybatis.java.services"})
public class ServicesContext {
}
