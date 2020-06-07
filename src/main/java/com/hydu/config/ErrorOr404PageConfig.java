package com.hydu.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @Author heyong
 * @Date: 2020/6/7  10:50
 * 拦截404、500等报错返回信息
 */
@Configuration
public class ErrorOr404PageConfig {
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        //配置不同的错误返回controller路径
        ErrorPage errorPage400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400");
        ErrorPage errorPage401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401");
        ErrorPage errorPage403 = new ErrorPage(HttpStatus.FORBIDDEN, "/error/403");
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        ErrorPage errorPage415 = new ErrorPage(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "/error/415");
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        factory.addErrorPages(errorPage400, errorPage401, errorPage403, errorPage404, errorPage415, errorPage500);
        return factory;
    }
}
