package com.cos.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MustacheViewResolver resolver = new MustacheViewResolver();
        resolver.setCharset("UTF-8");
        resolver.setContentType("text/html; charest=UTF-8");//던지는 데이터 : html파일
        resolver.setPrefix("classpath:/templates/");//classpath: -> 프로젝트
        resolver.setSuffix(".html"); //.html파일을 mustache가 인식할 수 있게 하기
        registry.viewResolver(resolver); //설정한 resolver 등록하기
    }
}
