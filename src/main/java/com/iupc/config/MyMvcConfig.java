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
        registry.addViewController("/shop").setViewName("shop_check");
        registry.addViewController("/searchnote").setViewName("search_result_note");
        registry.addViewController("/upload_note").setViewName("upload_note");
        registry.addViewController("/upload_shop").setViewName("upload_shop");
        registry.addViewController("/favorite_news").setViewName("favorite_zx");
        registry.addViewController("/favorite_note").setViewName("favorite_note");
        registry.addViewController("/favorite_goods").setViewName("favorite_goods");
        registry.addViewController("/upload_good").setViewName("upload_good");
        registry.addViewController("/admin_news").setViewName("administrator");
        registry.addViewController("/admin_notes").setViewName("admin_notes");
        registry.addViewController("/admin_shops").setViewName("admin_shops");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/message").setViewName("message");
        registry.addViewController("/person_information").setViewName("person_information");
        registry.addViewController("/Store_information").setViewName("Store_information");
        registry.addViewController("/discuss").setViewName("discuss");
        registry.addViewController("/shopcheck").setViewName("shop_check");
        registry.addViewController("/all_news_hf").setViewName("all_news_hf");
        registry.addViewController("/all_news_lolita").setViewName("all_news_lolita");
        registry.addViewController("/all_news_jk").setViewName("all_news_jk");
        registry.addViewController("/all_notes_hf").setViewName("all_notes_hf");
        registry.addViewController("/all_notes_lolita").setViewName("all_notes_lolita");
        registry.addViewController("/all_notes_jk").setViewName("all_notes_jk");
        registry.addViewController("/all_notes").setViewName("all_notes");
        registry.addViewController("/all_news").setViewName("all_news");
        registry.addViewController("/sgood").setViewName("search_result_goods");
        registry.addViewController("/admin_news").setViewName("admin_news");
        registry.addViewController("/admin_notes").setViewName("admin_notes");
        registry.addViewController("/discuss").setViewName("discuss");


    }

}
