package me.wbprime.springdbusecase.springdatajpa.java.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class: ServicesContext
 * Date: 2016/04/11 23:14
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
@Configuration
@ComponentScan(basePackages = {"me.wbprime.springdbusecase.springdatajpa.java.services.impl"})
public class ServicesContext {
}
