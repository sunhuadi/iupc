package com.iupc.pojo;

import java.sql.Timestamp;

public class FavoriteContent {

    private String ftype;//收藏类型
    private String fcid;//所收藏东西的id
    private String username;//所属用户
    private Timestamp time;//收藏时间

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getFcid() {
        return fcid;
    }

    public void setFcid(String fcid) {
        this.fcid = fcid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
