package com.iupc.Mapper;

import com.iupc.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {
    List<News> qurryAllNews();
    List<News> qurryAllNewsShow(String show);
    List<News> qurryNewsByContent(String value);
    News qurryNewsById(String value);
   // List<News> qurryNewsByContent(News news);
    void insertNews(News news);
    void insertNewsPic(NewsPic np);
    int getNewsNumber();
    String[] qurryPicbyId(String news_id);
    void updataNews(News news);


    void insertGoods(Goods good);
    void insertGoodsPic(GoodsPic gp);
    void insertGoodsNum(Goods_num gm);
    int getGoodsNumber();
    String[] qurryGoodsPicbyId(String good_id);
    Goods qurryGoodsById(String id);
    List<Goods> qurryGoodsBy(String value);
    String[] qurryGoodsColorByIdSzie(String id,String size);
    String[] qurryGoodsSizeById(String id);
    Goods_num qurryGoodsByIdSzieColor(String id,String size,String color);
}
