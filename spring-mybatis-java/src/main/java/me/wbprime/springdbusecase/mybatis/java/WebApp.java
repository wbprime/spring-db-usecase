package me.wbprime.springdbusecase.mybatis.java;


import me.wbprime.springdbusecase.mybatis.java.config.AppContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Class: WebApp
 * Date: 2016/04/11 23:01
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
public class WebApp extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {
            AppContext.class
        };

    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
            "/"
        };
    }

    @Override
    protected Filter[] getServletFilters() {
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }
}
