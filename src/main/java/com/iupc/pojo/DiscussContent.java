package com.sample;


public class DiscussContent {

  private String dcid;
  private String pubuser_id;
  private String answerto;
  private String content;
  private java.sql.Timestamp pubtime;
  private long discuss_id;


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

  public long getDiscuss_id() {
    return discuss_id;
  }

  public void setDiscuss_id(long discuss_id) {
    this.discuss_id = discuss_id;
  }
}
