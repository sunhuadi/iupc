package com.iupc.pojo;

import java.sql.Timestamp;

public class Goods {

    private String Goods_id;//商品id
    private String Goods_name;//商品名字
    private String Goods_price;//商品价格
    private java.sql.Timestamp Goods_time;//上架时间
    private String Goods_category;//商品类别
    private String Goods_link;//商品购买连接
    private String Goods_modality;//待定
    private String Goods_shopid;//所属商店id
    private String Goods_picture;//商品图片
    private String Goods_content;//商品介绍
    private int Goods_sum;//总剩余数
    private String  Goods_place;
    private String[] piclist;
    private String[] sizelist;
    private String[] colorlist;

    public String[] getPiclist() {
        return piclist;
    }

    public void setPiclist(String[] piclist) {
        this.piclist = piclist;
    }

    public String[] getSizelist() {
        return sizelist;
    }

    public void setSizelist(String[] sizelist) {
        this.sizelist = sizelist;
    }

    public String[] getColorlist() {
        return colorlist;
    }

    public void setColorlist(String[] colorlist) {
        this.colorlist = colorlist;
    }

    public String getGoods_id() {
        return Goods_id;
    }

    public void setGoods_id(String goods_id) {
        Goods_id = goods_id;
    }

    public String getGoods_name() {
        return Goods_name;
    }

    public void setGoods_name(String goods_name) {
        Goods_name = goods_name;
    }

    public String getGoods_price() {
        return Goods_price;
    }

    public void setGoods_price(String goods_price) {
        Goods_price = goods_price;
    }

    public Timestamp getGoods_time() {
        return Goods_time;
    }

    public void setGoods_time(Timestamp goods_time) {
        Goods_time = goods_time;
    }

    public String getGoods_content() {
        return Goods_content;
    }

    public void setGoods_content(String goods_content) {
        Goods_content = goods_content;
    }

    public int getGoods_sum() {
        return Goods_sum;
    }

    public void setGoods_sum(int goods_sum) {
        Goods_sum = goods_sum;
    }

    public String getGoods_place() {
        return Goods_place;
    }

    public void setGoods_place(String goods_place) {
        Goods_place = goods_place;
    }

    public String getGoods_category() {
        return Goods_category;
    }

    public void setGoods_category(String goods_category) {
        Goods_category = goods_category;
    }

    public String getGoods_link() {
        return Goods_link;
    }

    public void setGoods_link(String goods_link) {
        Goods_link = goods_link;
    }

    public String getGoods_modality() {
        return Goods_modality;
    }

    public void setGoods_modality(String goods_modality) {
        Goods_modality = goods_modality;
    }

    public String getGoods_shopid() {
        return Goods_shopid;
    }

    public void setGoods_shopid(String goods_shopid) {
        Goods_shopid = goods_shopid;
    }

    public String getGoods_picture() {
        return Goods_picture;
    }

    public void setGoods_picture(String goods_picture) {
        Goods_picture = goods_picture;
    }
}
