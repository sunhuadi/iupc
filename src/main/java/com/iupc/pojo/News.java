package com.iupc.pojo;

import java.util.Date;

public class News {
    private String news_id;
    private String news_content;
    private String news_author;
    private java.util.Date news_time;
    private String news_formattime;
    private String news_img;
    private String news_good;
    private String news_title;

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }
//private String news_id;
   // private String news_title;

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_author() {
        return news_author;
    }

    public void setNews_author(String news_author) {
        this.news_author = news_author;
    }

    public Date getNews_time() {
        return news_time;
    }

    public void setNews_time(Date news_time) {
        this.news_time = news_time;
    }

    public String getNews_formattime() {
        return news_formattime;
    }

    public void setNews_formattime(String news_formattime) {
        this.news_formattime = news_formattime;
    }

    public String getNews_img() {
        return news_img;
    }

    public void setNews_img(String news_img) {
        this.news_img = news_img;
    }

    public String getNews_good() {
        return news_good;
    }

    public void setNews_good(String news_good) {
        this.news_good = news_good;
    }
}
