package com.iupc.Mapper;

import com.iupc.pojo.News;
import com.iupc.pojo.NewsPic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {
    List<News> qurryAllNews();
    List<News> qurryNewsByContent(String value);
    News qurryNewsById(String value);
   // List<News> qurryNewsByContent(News news);
    void insertNews(News news);
    void insertNewsPic(NewsPic np);
    int getNewsNumber();
    String[] qurryPicbyId(String news_id);

}
