package com.iupc.service;

import com.iupc.pojo.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

public interface IIndexService {
    List<zixun> getAll();
    List<News> getAllnews();

    List<Object> getAllBysearch(String value,String v);


    News getNewsById(String value);
    Notes getNotesById(String id);
    Goods getgoodsById(String id);
    HashMap<String,String> setFavor(String id,String v);
    HashMap<String,String> delet(String id,String v);
    public List<Object> indexshow(String v,String show);
    public HashMap<String,String> admin(String v,String admin,String id);
    public List<Object> favor(String v);
    public List<DiscussContent> getDis();
    Shop getAllinformationByShopid(String id);
    public List<Object> recommend(String v);

}
