package com.iupc.pojo;

public class Goods {

    private String Goods_id;//商品id
    private String Goods_name;//商品名字
    private String Goods_price;//商品价格
    private String Goods_time;//上架时间
    private String Goods_category;//商品类别
    private String Goods_link;//商品购买连接
    private String Goods_modality;//待定
    private String Goods_shopid;//所属商店id
    private String Goods_picture;//商品图片
    private String Goods_introduce;//商品介绍
    private int Goods_Snum;//S剩余数目
    private int Goods_Mnum;
    private int Goods_Lnum;
    private int Goods_Sum;//总剩余数

    public int getGoods_Snum() {
        return Goods_Snum;
    }

    public void setGoods_Snum(int goods_Snum) {
        Goods_Snum = goods_Snum;
    }

    public int getGoods_Mnum() {
        return Goods_Mnum;
    }

    public void setGoods_Mnum(int goods_Mnum) {
        Goods_Mnum = goods_Mnum;
    }

    public int getGoods_Lnum() {
        return Goods_Lnum;
    }

    public void setGoods_Lnum(int goods_Lnum) {
        Goods_Lnum = goods_Lnum;
    }

    public int getGoods_Sum() {
        return Goods_Sum;
    }

    public void setGoods_Sum(int goods_Sum) {
        Goods_Sum = goods_Sum;
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

    public String getGoods_time() {
        return Goods_time;
    }

    public void setGoods_time(String goods_time) {
        Goods_time = goods_time;
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

    public String getGoods_introduce() {
        return Goods_introduce;
    }

    public void setGoods_introduce(String goods_introduce) {
        Goods_introduce = goods_introduce;
    }
}
