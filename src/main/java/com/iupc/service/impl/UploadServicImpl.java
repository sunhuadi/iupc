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
        String id=Integer.toString(nm.getNewsNumber());
        news.setNews_id(id);
        Timestamp time = new Timestamp(new Date().getTime());
        System.out.println("当前时间为:"+time);
        news.setNews_time(time);
        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();
        news.setNews_author(currentUser.getShowname());
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
    public HashMap<String,String> upload_note(MultipartFile[] files, MultipartFile file, Notes note) throws IOException{

        HashMap<String,String> mp=new HashMap<String,String>();
         //头像
        String path = fileUtil.uploadFile(file);
        note.setNote_img("http://39.97.113.33/"+path);
        System.out.println(note.getNote_img());
         //id
        String id=Integer.toString(notesMapper.getNotesNumber());
        note.setNote_id(id);
        //时间
        Timestamp time = new Timestamp(new Date().getTime());
        System.out.println("当前时间为:"+time);
        note.setNote_time(time);
        //作者

        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();
        note.setNote_author(currentUser.getShowname());
        notesMapper.insertNotes(note);
        System.out.println(files.length);
        for(int i=0;i<files.length;i++){
            if(files[i].isEmpty()){
                logger.info("文件不存在");
            }
            path = fileUtil.uploadFile(files[i]);
            if (path!=null)
            {
                notesMapper.insertNotesPic(new NotesPic("http://39.97.113.33/"+path,note.getNote_id()));
            }
            System.out.println("http://39.97.113.33/"+path);
        }
        mp.put("msg","上传成功");
        return mp;
    }

}
