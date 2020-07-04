package com.iupc.pojo;


import java.util.List;

public class DiscussContent {

  private String dcid;//讨论id
  private String pubuser_id;//发布者id
  private String answerto;//二级讨论所属一级内容，如果为-1则为
  private String content;//内容
  private java.sql.Timestamp pubtime;//发布时间
  private String shop_id;//所属商家id
  private String img;
  List<DiscussContent> discusslist;

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public List<DiscussContent> getDiscusslist() {
    return discusslist;
  }

  public void setDiscusslist(List<DiscussContent> discusslist) {
    this.discusslist = discusslist;
  }

  public String getDcid() {
    return dcid;
  }

  public void setDcid(String dcid) {
    this.dcid = dcid;
  }





  public String getAnswerto() {
    return answerto;
  }

  public void setAnswerto(String answerto) {
    this.answerto = answerto;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public java.sql.Timestamp getPubtime() {
    return pubtime;
  }

  public void setPubtime(java.sql.Timestamp pubtime) {
    this.pubtime = pubtime;
  }


  public String getPubuser_id() {
    return pubuser_id;
  }

  public void setPubuser_id(String pubuser_id) {
    this.pubuser_id = pubuser_id;
  }

  public String getShop_id() {
    return shop_id;
  }

  public void setShop_id(String shop_id) {
    this.shop_id = shop_id;
  }
}
