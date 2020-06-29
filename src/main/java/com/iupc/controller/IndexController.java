package com.iupc.controller;

import com.iupc.pojo.News;
import com.iupc.service.IIndexService;
import com.iupc.util.CommonFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IIndexService iis;
/*
    @GetMapping("/x")
    public String index(Model model)
    {
        List<zixun> zxlist=iis.getAll();
        model.addAttribute("zxlist",zxlist);

        return "index";
    }*/
    @ResponseBody
    @GetMapping("/getallnews")
    public List<News> index(Model model)
    {
       // Date date=new Date();
        System.out.println("util:"+new Date());
       // System.out.println("sql:"+new java.sql.Date(new Date()));
       // java.util.Date dt = new java.util.Date();
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //String currentTime = dt.toString();
        //Date date = new Date();
        List<News> newsList=iis.getAllnews();
        System.out.println(currentTime);
        return newsList;
    }

    @ResponseBody
    @PostMapping("/getonenews")
    public  List<News> getthatnew(@RequestBody HashMap<String,String> map)
    {
        String value=map.get("value");
        System.out.println("查看资讯，ID： "+map.get("value"));
        List<News> newsList =iis.getNewsById(value);
        return newsList;
    }

    @ResponseBody
    @PostMapping("/search")
    public List<News>Test(@RequestBody News news)//传入类型为News对象
    {
        //String value=map.get("value");
        System.out.println(news.getNews_title());
        System.out.println(news.getNews_content());
       // List<News> newsl=iis.getNewsBysearch(value);
        List<News> newsList=iis.getNewsBysearch(news);

       // System.out.println(newsList.get(0));
        return newsList;
    }
/*
    @ResponseBody
    @GetMapping("/test")
    public List<HashMap<String,String> >Test()
    {
        List<HashMap<String,String> >list = new ArrayList<HashMap<String, String>>();

        for (int i=0;i<2;i++)
        {
            HashMap<String,String> mp=new HashMap<String,String>();
           mp.put("name","sunhuadi"+i);
                list.add(i,mp);
        }
        return list;
    }*/

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private CommonFileUtil fileUtil;
    @ResponseBody
    @PostMapping("/ok")
    public String signup(@RequestParam("myfile") MultipartFile[] file,Model model) throws IOException {
        System.out.println(file.length);
        for(int i=0;i<file.length;i++){
            if(file[i].isEmpty()){
                logger.info("文件不存在");
            }
            String path = fileUtil.uploadFile(file[i]);
            System.out.println(path);
        }
        return "success";
    }
    @PostMapping("/ok")
    public String upload(@RequestParam("files")MultipartFile[] files)throws IOException
    {

        return "success";
    }



}
