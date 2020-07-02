package com.iupc.service;

import com.iupc.pojo.News;
import com.iupc.pojo.zixun;

import java.util.List;

public interface IIndexService {
    List<zixun> getAll();
    List<News> getAllnews();
    List<News> getNewsBysearch(String value);
    News getNewsById(String value);

}
