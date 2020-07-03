package com.iupc.controller;

import com.iupc.Mapper.NewsMapper;
import com.iupc.Mapper.NotesMapper;
import com.iupc.pojo.Goods;
import com.iupc.pojo.Goods_num;
import com.iupc.pojo.News;
import com.iupc.pojo.Notes;
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
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    NewsMapper newsMapper;
    @ResponseBody
    @GetMapping("/getallnews")
    public List<News> index(Model model)
    {
        System.out.println("util:"+new Date());
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        List<News> newsList=iis.getAllnews();
        System.out.println(currentTime);
        return newsList;
    }
    @Autowired
    NotesMapper notesMapper;
    @ResponseBody
    @GetMapping("/getallnotes")
    public List<Notes> allnote()
    {
        List<Notes> notes=notesMapper.qurryAllNotes();
        return notes;
    }
    @ResponseBody
    @GetMapping("/getallgoods")
    public List<Goods> allgoods(Model model)
    {
        List<Goods> notes=newsMapper.qurryAllGoods();
        return notes;
    }

    @ResponseBody
    @GetMapping("/getallnewsshow1")//可扩展到其他方面
    public List<News> indexshow1(Model model)
    {
        List<News> newsList=newsMapper.qurryAllNewsShow("0");
        return newsList;
    }


    @ResponseBody
    @PostMapping("/getonenews")
    public  News getthatnew(@RequestBody HashMap<String,String> map)
    {
        String value=map.get("value");
        System.out.println("查看资讯，ID： "+map.get("value"));
        News news =iis.getNewsById(value);

        return news;
    }
    @ResponseBody
    @PostMapping("/getnotbyid")
    public Notes getnotebyid(@RequestBody HashMap<String,String> map)
    {
        String id=map.get("id");
        System.out.println("查看笔记，ID： "+map.get("id"));
        return iis.getNotesById(id);
    }
    @ResponseBody
    @PostMapping("/getonegoods")
    public Goods getgoodsbyid(@RequestBody HashMap<String,String> map)
    {
        String id=map.get("id");
        System.out.println("商品，ID： "+map.get("id"));
        return iis.getgoodsById(id);
    }

    @ResponseBody
    @PostMapping("/getcolor")
    public String[] getcolor(@RequestBody HashMap<String,String> map)
    {

        String id=map.get("id");
        String size=map.get("size");
        System.out.println("Size： "+map.get("size"));
        return newsMapper.qurryGoodsColorByIdSzie(id,size);
    }
    @ResponseBody
    @PostMapping("/getnumprice")
    public Goods_num getnumprice(@RequestBody HashMap<String,String> map)
    {
        String id=map.get("id");
        String size=map.get("size");
        String color=map.get("color");
        System.out.println("商品，ID,颜色 "+id+size+color);
        return newsMapper.qurryGoodsByIdSzieColor(id,size,color);
    }

    @ResponseBody
    @PostMapping("/admin1")
    public HashMap<String,String> admin(@RequestBody HashMap<String,String> map)
    {
        String admin=map.get("admin");
        String id=map.get("id");
        System.out.println(id+admin);
        News news=new News();
        news.setNews_id(id);
        news.setNews_show(admin);
        newsMapper.updataNews(news);
        HashMap<String,String> mp=new HashMap<>();
        mp.put("msg","操作成功！");
        return mp ;
    }

    @ResponseBody
    @PostMapping("/search")//适应于三种情况
    public List<Object> Test(@RequestBody HashMap<String,String> map)//传入类型为map
    {
        //map.get("value");
        //List<News> newsList=iis.getNewsBysearch(map.get("value"));
            List<Object> objList= iis.getNewsBysearch(map.get("value"),map.get("variable"));
        return objList;
    }
    @ResponseBody
    @PostMapping("/delet")//适应于三种情况
    public HashMap<String,String> delet(@RequestBody HashMap<String,String> map)//传入类型为map,盲写
    {
        //map.get("value");
        //List<News> newsList=iis.getNewsBysearch(map.get("value"));
        return iis.delet(map.get("id"),map.get("variable"));
    }

    @ResponseBody
    @PostMapping("/searchgoods")
    public List<Object> getGoods(@RequestBody HashMap<String,String> map)//传入类型为map
    {
        //map.get("value");
        //List<News> newsList=iis.getNewsBysearch(map.get("value"));
        List<Object> objList= iis.getNewsBysearch(map.get("value"),map.get("variable"));


        return objList;
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
    @PostMapping("/pics")
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
    @ResponseBody
    @PostMapping("/favor")
    public HashMap<String,String>favor(@RequestBody HashMap<String,String> map)//传入类型为map
    {

        String v=null;
        //List<News> newsList=iis.getNewsBysearch(map.get("value"));
        if(map.get("variable").equals("1"))
        {
            v="Note";
        }
        //List<Object> objList= iis.getNewsBysearch(map.get("value"),map.get("variable"));

        return iis.setFavor(map.get("id"),v);
    }





}
