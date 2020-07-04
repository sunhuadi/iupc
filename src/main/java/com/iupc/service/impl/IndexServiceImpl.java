package com.iupc.service.impl;

import com.iupc.Mapper.NewsMapper;
import com.iupc.Mapper.NotesMapper;
import com.iupc.Mapper.UsersMapper;
import com.iupc.Mapper.ZixunMapper;
import com.iupc.pojo.*;
import com.iupc.service.IIndexService;
import jdk.nashorn.internal.objects.NativeMath;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

import static java.lang.Math.min;

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

    @Override
    public List<News> getAllnews() {
       // String formatDate = null;

        return ns.qurryAllNews();
    }


@Autowired
NotesMapper notesMapper;
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    NewsMapper newsMapper;
    @Override
    public List<Object> getAllBysearch(String  value,String v) {
        List<Object> objList=new ArrayList<>();
        if(v.equals("0"))
        {
            if(value!=null)
            {
                 objList= Collections.singletonList(ns.qurryNewsByContent(value));
            }
            else {
                  objList= Collections.singletonList(ns.qurryAllNews());
            }
            return objList;
        }else if(v.equals("1")){
            if(value!=null)
            {
                objList= Collections.singletonList(notesMapper.qurryNotesBysearch(value));
            }
            else {
                objList= Collections.singletonList(notesMapper.qurryAllNotes());
            }
            return objList;
        }else
        {
            if(value!=null)
            {
                objList= Collections.singletonList(ns.qurryGoodsBy(value));
            }
            else {
                objList= Collections.singletonList(ns.qurryAllGoods());
            }

            return objList;
        }

    }
    @Override
    public List<Object> indexshow(String v,String show){
        List<Object> list=new ArrayList<>();
        if(v.equals("0"))
        {
            if(show!=null)
            {
                list= Collections.singletonList(newsMapper.qurryAllNewsByShow(show));
            }
            else {
                list= Collections.singletonList(newsMapper.qurryAllNews());
            }

        }
        else if (v.equals("2")){
            if(show!=null)
            {
                list= Collections.singletonList(newsMapper.qurryAllGoodsByShow(show));
            }
            else {
                list= Collections.singletonList(newsMapper.qurryAllGoods());
            }
        }
        else {
            if(show!=null)
            {
                list= Collections.singletonList(notesMapper.qurryAllNotesByShow(show));
            }
            else {
                list= Collections.singletonList(notesMapper.qurryAllNotesByShow(show));
            }
        }
        return list;


    }
    @Override
    public List<Object> favor(String v){
        List<Object> list=new ArrayList<>();
        System.out.println(v);
        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();
        if(v.equals("0")) {
            if(newsMapper.qurryAllNewsByFavor(currentUser.getUsername(), v)!=null)
            list= Collections.singletonList(newsMapper.qurryAllNewsByFavor(currentUser.getUsername(), v));
        }
        else if (v.equals("1"))
        {
            if(notesMapper.qurryAllNotesByFavor(currentUser.getUsername(), v)!=null)
            list= Collections.singletonList(notesMapper.qurryAllNotesByFavor(currentUser.getUsername(), v));
        }else {
            if(newsMapper.qurryAllGoodsByFavor(currentUser.getUsername(), v)!=null)
            list= Collections.singletonList(newsMapper.qurryAllGoodsByFavor(currentUser.getUsername(), v));
        }

        return list;


    }
    @Override
    public HashMap<String,String> admin(String v,String admin,String id){
        if(v.equals("0"))
        {
            newsMapper.updataNewsByShow(id,admin);
        }
        else if(v.equals("1"))
        {
            notesMapper.updataNotesByShow(id,admin);
        }else
        {
            newsMapper.updataGoodsByShow(id,admin);
        }

        HashMap<String,String> mp=new HashMap<>();
        mp.put("msg","操作成功！");
        return mp ;
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
@Override
public List<DiscussContent> getDis(){
        List<DiscussContent> list=usersMapper.getDiscussBytoid("-1");
        for(int i=0;i<list.size();i++)
        {
            Users users=usersMapper.getUserByName(list.get(i).getPubuser_id());

            List<DiscussContent> list2=usersMapper.getDiscussBytoid(list.get(i).getDcid());
            if(list2!=null)
            {
                list.get(i).setImg(users.getPortrait());
                for(int j=0;j<list2.size();j++)
                {
                    Users users2=usersMapper.getUserByName(list2.get(j).getPubuser_id());
                    list2.get(j).setImg(users2.getPortrait());
                }
                list.get(i).setDiscusslist(list2);
            }
        }
        return list;


}
@Override
public Shop getAllinformationByShopid(String id)
{

    Shop shop=new Shop();
    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
    if(!pattern.matcher(id).matches())//不是数字构成，为用户名
    {
         shop=usersMapper.getShopByName(id);
        id=shop.getShop_id();
    }
    else {
         shop=usersMapper.qurryShopById(id);
    }


    List<Goods> goods=newsMapper.qurryGoodsByShopid(id);
    if (goods!=null)
    shop.setGoodsList(goods);

    return shop;
}
@Override
    public List<Object> recommend(String v){
    List<Object> list=new ArrayList<>();
    System.out.println(v);
    Subject subject1 = SecurityUtils.getSubject();
    Users currentUser=(Users) subject1.getPrincipal();

        String[] key =usersMapper.qurryRecordByusername("admin");
        for(int i=0;i< min(key.length,3);i++)
        {
            System.out.println(key[i]);
            list.addAll(getAllBysearch(key[i],v));
        }
    return list;
    }

}

