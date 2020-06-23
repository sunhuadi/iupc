package com.iupc.pojo;

import javax.xml.crypto.Data;
import java.util.Date;

public class zixun {
    private String title;
    private String content;
    private String image;
    //private Data time;
    private java.util.Date time;
    private String formattime;

    public void setFormattime(String formattime) {
        this.formattime = formattime;
    }

    public String getFormattime() {
        return formattime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public Date getTime() {
        return time;
    }

}
