package com.iupc.pojo;

public class Goods_num {
    private String good_id;//商品id
    private String good_color;//商品颜色
    private String good_size;//商品规格
    private int good_num;//商品数目
    private String good_price;//商品数目
    public String getGood_id() {
        return good_id;
    }

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public String getGood_color() {
        return good_color;
    }

    public String getGood_price() {
        return good_price;
    }

    public void setGood_price(String good_price) {
        this.good_price = good_price;
    }

    public void setGood_color(String good_color) {
        this.good_color = good_color;
    }

    public String getGood_size() {
        return good_size;
    }

    public void setGood_size(String good_size) {
        this.good_size = good_size;
    }

    public int getGood_num() {
        return good_num;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }
}
