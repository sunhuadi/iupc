package com.iupc.Mapper;

import com.iupc.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {
    List<News> qurryAllNews();
    List<News> qurryNewsByContent(String value);
    List<News> qurryNewsById(String value);
    List<News> qurryNewsByContent(News news);
    void insertNews(News news);

}
