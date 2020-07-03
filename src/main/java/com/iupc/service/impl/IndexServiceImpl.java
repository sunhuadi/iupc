package com.iupc.service.impl;

import com.iupc.Mapper.NewsMapper;
import com.iupc.Mapper.NotesMapper;
import com.iupc.Mapper.UsersMapper;
import com.iupc.Mapper.ZixunMapper;
import com.iupc.pojo.*;
import com.iupc.service.IIndexService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.zip.DataFormatException;

@Service("IndexServic")
public class IndexServiceImpl implements IIndexService {

    @Autowired
    ZixunMapper zx;
    @Autowired
    NewsMapper ns;

    @Override
    public List<zixun> getAll() {
        String formatDate = null;
        // System.out.println("ok?");
        List<zixun> zxlist = zx.qurryzixunall();
        for (int i = 0; i < zxlist.size(); i++) {
            //System.out.println(zxlist.get(i).getTime());

           // zxlist.get(i).setFormattime(DateFormat.getDateInstance(DateFormat.FULL).format(zxlist.get(i).getTime()));
            // System.out.println(zxlist.get(i).getFormattime());
        }
        return zxlist;
    }

    public List<News> getAllnews() {
       // String formatDate = null;

        return ns.qurryAllNews();
    }


@Autowired
NotesMapper notesMapper;
    @Override
    public List<Object>getNewsBysearch(String  value,String v) {
        if(v.equals("0"))
        {
            List<Object> objList= Collections.singletonList(ns.qurryNewsByContent(value));
            return objList;
        }else if(v.equals("1")){
            List<Object> objList= Collections.singletonList(notesMapper.qurryNotesBysearch(value));
            return objList;
        }else {
            List<Object> objList= Collections.singletonList(ns.qurryGoodsBy(value));
            return objList;
        }

    }
    @Override
   public HashMap<String,String> delet(String id,String v){
        HashMap<String,String> mp=new HashMap<>();

        if(v.equals("0"))
        {
            ns.deletNewsByid(id);
            mp.put("msg","删除一条资讯成功！");
            return mp;
        }else if(v.equals("1")){
            notesMapper.deletNotesByid(id);
            mp.put("msg","删除一条笔记成功！");
            return mp;
        }else {
            ns.deletGoodsByid(id);
            mp.put("msg","删除一个商品成功！");

            return mp;
        }

    }

    @Override
    public News getNewsById(String value) {
        News news=ns.qurryNewsById(value);
        String[] pic=ns.qurryPicbyId(value);

        for(int i=0;i<pic.length;i++)
        {
            System.out.println(pic[i]);
        }
        if(pic!=null)
        news.setNews_pic(pic);

        return news;
    }

    @Override

    public Notes getNotesById(String id)
    {
        Notes note=notesMapper.qurryNoteById(id);
        note.setNote_pic(notesMapper.qurryNotePicbyId(id));

        return note;
    }

    public Goods getgoodsById(String id){
        System.out.println("正在查询，请稍后");
        Goods good=ns.qurryGoodsById(id);
        System.out.println("查询规格"+ns.qurryGoodsSizeById(id));
        good.setSizelist(ns.qurryGoodsSizeById(id));
        good.setPiclist(ns.qurryGoodsPicbyId(id));
        return good;
    }

    @Autowired
    UsersMapper usersMapper;
    @Override
  public  HashMap<String,String> setFavor(String id, String v){
        FavoriteContent fc=new FavoriteContent();
        fc.setFcid(id);
        fc.setFtype(v);
        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();
        Timestamp time = new Timestamp(new Date().getTime());
        System.out.println("当前时间为:"+time);
        fc.setTime(time);
        fc.setUsername(currentUser.getUsername());
        usersMapper.insertFover(fc);
        HashMap<String,String> mp=new HashMap<String,String>();
        mp.put("msg","收藏成功");
        return mp;
    }

}

