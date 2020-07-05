package com.iupc.service.impl;
import com.iupc.Mapper.NewsMapper;
import com.iupc.Mapper.NotesMapper;
import com.iupc.Mapper.UsersMapper;
import com.iupc.controller.IndexController;
import com.iupc.pojo.*;
import com.iupc.service.IUploadService;
import com.iupc.util.CommonFileUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("UploadServic")
public class UploadServicImpl implements IUploadService {
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private CommonFileUtil fileUtil;
    @Autowired
    NewsMapper nm;
    public HashMap<String,String> upload_news(MultipartFile[] files,MultipartFile file,News news) throws IOException{

        HashMap<String,String> mp=new HashMap<String,String>();

        String path = fileUtil.uploadFile(file);
        news.setNews_img("http://39.97.113.33/"+path);
        System.out.println(news.getNews_img());
        String id=Integer.toString(nm.getNewsNumber()+1);
        news.setNews_id(id);
        Timestamp time = new Timestamp(new Date().getTime());
        System.out.println("当前时间为:"+time);
        news.setNews_time(time);
        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();
        if(currentUser==null)
        {
            mp.put("msg","请先登陆！");
            return mp;
        }
        news.setNews_author(currentUser.getUsername());
        nm.insertNews(news);

       // System.out.println("转换为sql时间为:"+news.getNews_time());
       // System.out.println("上传上新时间测试为:"+news.getNews_begintime());
       // System.out.println(files.length);
        for(int i=0;i<files.length;i++){
            if(files[i].isEmpty()){
                logger.info("文件不存在");
            }
             path = fileUtil.uploadFile(files[i]);
            if (path!=null)
            {
                nm.insertNewsPic(new NewsPic("http://39.97.113.33/"+path,news.getNews_id()));

            }
            System.out.println("http://39.97.113.33/"+path);
        }
        mp.put("msg","上传成功！");
        return mp;
    }
    @Autowired
    UsersMapper usersMapper;
    public HashMap<String,String> upload_user(MultipartFile file, Users user) throws IOException{
        HashMap<String,String> mp=new HashMap<String,String>();
        usersMapper.getUserByName(user.getUsername());
        if(usersMapper.getUserByName(user.getUsername())!=null)
        {

             mp.put("code","1");
             mp.put("msg","该用户已被注册");
            return mp;
        }
        String path = fileUtil.uploadFile(file);
        user.setPortrait("http://39.97.113.33/"+path);
        System.out.println(user.getPortrait());
        user.setRole("2");
        usersMapper.insertUsers(user);
        mp.put("code","0");
        mp.put("msg","注册成功");
        return mp;
    }

    @Autowired
    NotesMapper notesMapper;
    public HashMap<String,String> upload_note(MultipartFile[] files, MultipartFile file, Notes note,List<NewsNotes> newsNotesList) throws IOException{

        HashMap<String,String> mp=new HashMap<String,String>();


         //头像
        String path = fileUtil.uploadFile(file);
        note.setNote_img("http://39.97.113.33/"+path);
        System.out.println(note.getNote_img());
         //id

        String id=Integer.toString((notesMapper.getNotesNumber()+1));
        System.out.println(id);
        note.setNote_id(id);

//关联关系
        for(int i=0;i<newsNotesList.size();i++)
        {
            if(nm.qurryNewsById(newsNotesList.get(i).getNews_id())==null)
            {
                mp.put("msg","资讯"+newsNotesList.get(i).getNews_id()+"不存在，请重新填写！");
                return mp;
            }
            System.out.println(id);
            newsNotesList.get(i).setNote_id(id);
            notesMapper.insertNewsNote(newsNotesList.get(i));
        }
        //时间
        Timestamp time = new Timestamp(new Date().getTime());
        System.out.println("当前时间为:"+time);
        note.setNote_time(time);
        //作者
        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();
        note.setNote_author(currentUser.getUsername());
        if(currentUser==null)
        {
            mp.put("msg","请先登陆！");
            return mp;
        }
        notesMapper.insertNotes(note);
        System.out.println(files.length);
        for(int i=0;i<files.length;i++){
            if(files[i].isEmpty()){
                logger.info("文件不存在");
            }
            path = fileUtil.uploadFile(files[i]);
            if (path!=null)
            {
                notesMapper.insertNotesPic(new NotesPic(note.getNote_id(),"http://39.97.113.33/"+path));
            }
            System.out.println("http://39.97.113.33/"+path);
        }
        mp.put("msg","上传成功");
        return mp;
    }

    public HashMap<String,String> upload_goods(MultipartFile[] files, MultipartFile file, Goods good, List<Goods_num> goods_num) throws IOException
    {
        HashMap<String,String> mp=new HashMap<String,String>();
        //头像
        String path = fileUtil.uploadFile(file);
        good.setGoods_picture("http://39.97.113.33/"+path);
        System.out.println(good.getGoods_picture());
        //id
        String id=Integer.toString(nm.getGoodsNumber()+1);
        good.setGoods_id(id);
        //时间
        Timestamp time = new Timestamp(new Date().getTime());
        System.out.println("当前时间为:"+time);
        good.setGoods_time(time);
        //作者

        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();


        if(currentUser==null)
        {
            mp.put("msg","请先登陆！");
            return mp;
        }
        good.setGoods_shopid(usersMapper.getShopByName(currentUser.getUsername()).getShop_id());//设置用户对应的账户id
        System.out.println(files.length);
        for(int i=0;i<files.length;i++){
            if(files[i].isEmpty()){
                logger.info("文件不存在");
            }
            path = fileUtil.uploadFile(files[i]);
            if (path!=null)
            {
               // notesMapper.insertNotesPic(new NotesPic(note.getNote_id(),"http://39.97.113.33/"+path));
                nm.insertGoodsPic(new GoodsPic(good.getGoods_id(),"http://39.97.113.33/"+path));
            }
            System.out.println("http://39.97.113.33/"+path);
        }
        int sum=0;
        for(int i=0;i<goods_num.size();i++)
        {
            goods_num.get(i).setGood_id(good.getGoods_id());
            if (goods_num.get(i).getGood_num()!=0){
                sum=sum+goods_num.get(i).getGood_num();
                nm.insertGoodsNum(goods_num.get(i));
            }
        }
        good.setGoods_sum(sum);
        nm.insertGoods(good);
        mp.put("msg","上传成功");
        return mp;
    }


    public HashMap<String,String> upload_discuss(DiscussContent discussContent){
        System.out.println(usersMapper.getIdtoSet());
        discussContent.setDcid(Integer.toString(usersMapper.getIdtoSet()+1));
        if(discussContent.getAnswerto()==null)
        {
            discussContent.setAnswerto("-1");//代表一级讨论信息
        }
        HashMap<String,String> mp=new HashMap<String,String>();
        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();
        if(currentUser==null)
        {
            mp.put("msg","请先登陆！");
            return mp;
        }
        discussContent.setPubuser_id(currentUser.getUsername());
        Timestamp time = new Timestamp(new Date().getTime());
        discussContent.setPubtime(time);
        System.out.println(discussContent.getContent());
        usersMapper.insertDiscuss(discussContent);
        mp.put("msg","上传成功！");
        return mp;
    }

    public HashMap<String,String> applyshop(MultipartFile file, Shop shop) throws IOException{
        HashMap<String,String> mp=new HashMap<String,String>();
        shop.setShop_id(Integer.toString(usersMapper.getMaxShopid()+1));
        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();
        if(currentUser==null)
        {
            mp.put("msg","请先登陆！");
            return mp;
        }
        usersMapper.updateUserRole(currentUser);
        //shop.setUsername(currentUser.getUsername());
        shop.setUsername(currentUser.getUsername());
        String path = fileUtil.uploadFile(file);
        shop.setShop_pic("http://39.97.113.33/"+path);
        Timestamp time = new Timestamp(new Date().getTime());
        System.out.println("当前时间为:"+time);
        shop.setShop_atime(time);
        usersMapper.insertShop(shop);
        mp.put("msg","上传成功！");
        return mp;
    }


}
