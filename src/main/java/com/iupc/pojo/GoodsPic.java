package com.iupc.pojo;

public class GoodsPic {
    private String goods_id;
    private String goods_pic;

    public GoodsPic(String goods_id, String goods_pic) {
        this.goods_id = goods_id;
        this.goods_pic = goods_pic;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }
}
