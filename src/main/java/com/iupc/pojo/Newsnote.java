package com.iupc.pojo;

import lombok.NoArgsConstructor;


public class Newsnote {
    private String news_id;
    private String note_id;

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getNote_id() {
        return note_id;
    }

    public void setNote_id(String note_id) {
        this.note_id = note_id;
    }
}
