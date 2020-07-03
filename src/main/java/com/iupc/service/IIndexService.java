package com.iupc.service;

import com.iupc.pojo.Goods;
import com.iupc.pojo.News;
import com.iupc.pojo.Notes;
import com.iupc.pojo.zixun;

import java.util.List;

public interface IIndexService {
    List<zixun> getAll();
    List<News> getAllnews();
    List<Object> getNewsBysearch(String value,String v);
    News getNewsById(String value);
    Notes getNotesById(String id);
    Goods getgoodsById(String id);
}
