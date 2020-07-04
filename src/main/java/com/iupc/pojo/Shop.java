package com.iupc.pojo;


import java.util.List;

public class Shop {

  private String shop_name;//商店名字
  private String shop_introduce;//店铺介绍
  private String shop_pic;//店铺头像
  private String username;//店铺所属用户
  private String shop_id;//商店id
  private List<Goods> goodsList;

  public List<Goods> getGoodsList() {
    return goodsList;
  }

  public void setGoodsList(List<Goods> goodsList) {
    this.goodsList = goodsList;
  }

  public String getShop_id() {
    return shop_id;
  }

  public void setShop_id(String shop_id) {
    this.shop_id = shop_id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getShop_name() {
    return shop_name;
  }

  public void setShop_name(String shop_name) {
    this.shop_name = shop_name;
  }


  public String getShop_introduce() {
    return shop_introduce;
  }

  public void setShop_introduce(String shop_introduce) {
    this.shop_introduce = shop_introduce;
  }

  public String getShop_pic() {
    return shop_pic;
  }

  public void setShop_pic(String shop_pic) {
    this.shop_pic = shop_pic;
  }
}
