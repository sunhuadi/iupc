package com.iupc.pojo;


import java.sql.Timestamp;

public class Notes {

  private String note_id;
  private String note_author;
  private java.sql.Timestamp note_time;
  private String note_goods;
  private String note_zx;
  private String note_content;

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

  public String getNote_goods() {
    return note_goods;
  }

  public void setNote_goods(String note_goods) {
    this.note_goods = note_goods;
  }

  public String getNote_zx() {
    return note_zx;
  }

  public void setNote_zx(String note_zx) {
    this.note_zx = note_zx;
  }

  public String getNote_content() {
    return note_content;
  }

  public void setNote_content(String note_content) {
    this.note_content = note_content;
  }
}
