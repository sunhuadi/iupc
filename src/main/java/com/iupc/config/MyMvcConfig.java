package com.iupc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/zxck").setViewName("zxck");
        registry.addViewController("test2").setViewName("test1");
        registry.addViewController("news").setViewName("news");
        registry.addViewController("note").setViewName("note");
        registry.addViewController("/upload").setViewName("test/pictest");
        registry.addViewController("/search_result").setViewName("search_result");
        registry.addViewController("/upload_news").setViewName("upload_news");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/signup").setViewName("denglu");
        //registry.addViewController("/zxck").setViewName("note");

    }

}
