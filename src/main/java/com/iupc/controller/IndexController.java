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

import java.io.*;
import java.util.ArrayList;
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
    @GetMapping("/getnews")
    public List<News> index(Model model)
    {
        List<News> newsList=iis.getAllnews();
        System.out.println(newsList.get(0));
        return newsList;
    }

    @ResponseBody
    @GetMapping("/getonenews")
    public  List<News> getthatnew(@RequestBody HashMap<String,String> map)
    {
        String value=map.get("value");
        System.out.println(map.get("value"));
        List<News> newsList =iis.getNewsById(value);
        return newsList;
    }

    @ResponseBody
    @PostMapping("/search")
    public List<News> Test(@RequestBody HashMap<String,String> map)//传入类型为键值对
    {
        String value=map.get("value");
        System.out.println(map.get("value"));
        List<News> newsList=iis.getNewsById(value);
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
    @RequestMapping("/ok")
    public String signup(@RequestParam("myfile") MultipartFile file,Model model) throws IOException {
        if(file.isEmpty()){
            logger.info("文件不存在");
        }
        String path = fileUtil.uploadFile(file);

        System.out.println(path);
        return "success";
    }


}
