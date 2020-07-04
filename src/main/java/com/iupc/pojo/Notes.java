package com.iupc.pojo;


import java.sql.Timestamp;
import java.util.List;

public class Notes {

    private String note_id;//笔记id



    private String note_author;//笔记作者
    private java.sql.Timestamp note_time;//笔记发布时间
    private String note_content;//笔记内容
    private String note_title;//笔记标题

    private String note_img;
    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public String[] getNote_pic() {
        return note_pic;
    }

    public void setNote_pic(String[] note_pic) {
        this.note_pic = note_pic;
    }

    private String[] note_pic;//多图
    public String getNote_img() {
        return note_img;
    }

    public void setNote_img(String note_img) {
        this.note_img = note_img;
    }

    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }
    public String getNote_id() {
        return note_id;
    }

    public void setNote_id(String note_id) {
        this.note_id = note_id;
    }

    public String getNote_author() {
        return note_author;
    }

    public void setNote_author(String note_author) {
        this.note_author = note_author;
    }

    public Timestamp getNote_time() {
        return note_time;
    }

    public void setNote_time(Timestamp note_time) {
        this.note_time = note_time;
    }


    public String getNote_content() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content = note_content;
    }
}
