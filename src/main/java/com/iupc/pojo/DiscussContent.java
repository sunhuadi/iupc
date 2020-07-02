package com.iupc.pojo;


public class DiscussContent {

  private String dcid;//讨论id
  private String pubuser_id;//发布者id
  private String answerto;//二级讨论所属一级内容，如果为-1则为
  private String content;//内容
  private java.sql.Timestamp pubtime;//发布时间
  private long shop_id;//所属商家id


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

  public long getShop_id() {
    return shop_id;
  }

  public void setShop_id(long shop_id) {
    this.shop_id = shop_id;
  }
}
