package com.iupc.controller;

import com.iupc.Mapper.NewsMapper;
import com.iupc.Mapper.NotesMapper;
import com.iupc.pojo.News;
import com.iupc.pojo.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {


    @RequestMapping("/test/add")
    public String add()
    {
        return  "test/add";
    }
    @RequestMapping("/test/update")
    public String update()
    {
        return  "test/update";
    }

    @Autowired
    NotesMapper np;
    @Autowired
    NewsMapper nm;
    @ResponseBody
    @RequestMapping("/testnote")
    public List<Notes> tn()
    {
        return np.qurryAllNotes();
    }

    @ResponseBody
    @RequestMapping("/testinsert")
    public void insert()
    {
        //Date time=new Date();
        Timestamp time = new Timestamp(new Date().getTime());
       News news=new News();
        news.setNews("插入测试","插入测试","插入测试",time,"插入测试","插入测试","插入测试",time,time,"插入测试",11);
        nm.insertNews(news);
    }
}
