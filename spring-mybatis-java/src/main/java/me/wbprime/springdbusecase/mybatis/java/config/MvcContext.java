package me.wbprime.springdbusecase.mybatis.java.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

/**
 * Class: MvcContext
 * Date: 2016/04/10 12:28
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"me.wbprime.springdbusecase.mybatis.java.controllers"})
public class MvcContext extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
            .addResourceLocations("/static/");
    }

    @Override
    public void configureDefaultServletHandling(
        final DefaultServletHandlerConfigurer configurer
    ) {
        configurer.enable();
    }

    @Bean
    public HandlerExceptionResolver exceptionResolver() {
        return new ExceptionHandlerExceptionResolver();
    }

    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver();
    }
}
