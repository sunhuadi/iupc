package com.iupc.pojo;

public class Users {
    private String userid;//登录名
    private String userpassword;
    private String portrait;
    private String userpermission;
    private String username;//昵称
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getUserpermission() {
        return userpermission;
    }

    public void setUserpermission(String userpermission) {
        this.userpermission = userpermission;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
