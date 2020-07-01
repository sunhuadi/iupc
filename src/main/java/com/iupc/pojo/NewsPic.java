package com.iupc.pojo;

import jdk.nashorn.internal.objects.annotations.Constructor;

public class NewsPic {
    private String news_pic;
    private String news_id;

    public NewsPic(String news_pic, String news_id) {
        this.news_pic = news_pic;
        this.news_id = news_id;
    }

    public String getNews_pic() {
        return news_pic;
    }

    public void setNews_pic(String news_pic) {
        this.news_pic = news_pic;
    }
    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }
}
