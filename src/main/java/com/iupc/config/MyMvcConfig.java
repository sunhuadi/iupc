package com.iupc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
       // registry.addViewController("/").setViewName("index");
        registry.addViewController("zxck").setViewName("zxck");
        registry.addViewController("test2").setViewName("test1");
    }

}
