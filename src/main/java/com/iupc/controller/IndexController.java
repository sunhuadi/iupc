package com.iupc.controller;

import com.iupc.Mapper.NewsMapper;
import com.iupc.Mapper.NotesMapper;
import com.iupc.Mapper.UsersMapper;
import com.iupc.pojo.*;
import com.iupc.service.IIndexService;
import com.iupc.util.CommonFileUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
        List<Notes> notes=notesMapper.qurryAllNotesByShow("1");
        return notes;
    }
    @ResponseBody
    @GetMapping("/getallgoods")
    public List<Goods> allgoods(Model model)
    {
        List<Goods> notes=newsMapper.qurryAllGoodsByShow("1");
        return notes;
    }


    @ResponseBody
    @PostMapping("/getonenews")
    public  News getthatnew(@RequestBody HashMap<String,String> map)
    {
        String value=map.get("value");
        System.out.println("查看资讯，ID： "+map.get("value"));
        News news =iis.getNewsById(value);
        news.setAuthor_name(usersMapper.getShopByName(news.getNews_author()).getShop_name());
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
    public Goods_num getnumprice(@RequestBody HashMap<String,String> map) {
        String id = map.get("id");
        String size = map.get("size");
        String color = map.get("color");
        System.out.println("商品，ID,颜色 " + id + size + color);
        return newsMapper.qurryGoodsByIdSzieColor(id, size, color);
    }
    @ResponseBody
    @PostMapping("/getallnewsshow1")//可扩展到其他方面
    public List<Object> indexshow1(@RequestBody HashMap<String,String> map)
    {
        String v=map.get("variable");
        String admin=map.get("admin");

        return iis.indexshow(v,admin);
    }
    @ResponseBody
    @PostMapping("/admin1")
    public HashMap<String,String> admin(@RequestBody HashMap<String,String> map)
    {
        String admin=map.get("admin");
        String id=map.get("id");
        String v=map.get("variable");
       // System.out.println(id+admin);
        return iis.admin(v,admin,id) ;
    }
@Autowired
    UsersMapper usersMapper;
    @ResponseBody
    @PostMapping("/search")//适应于三种情况
    public List<Object> Test(@RequestBody HashMap<String,String> map)//传入类型为map,0资讯，1note,2goods,value为空查询所有
    {

        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();
        Record record=usersMapper.qurryRecordBynk("admincs",map.get("value"));
        if(record==null)
    {
        Record record1=new Record();
        record1.setKey(map.get("value"));
        record1.setTimes(1);
        record1.setUsername("admincs");
        usersMapper.insertRecord(record1);
    }
     else {
            System.out.println("开始更新");
            usersMapper.updateTimes(record);
        }
        System.out.println(map.get("value"));
        System.out.println(map.get("variable"));
        //map.get("value");
        //List<News> newsList=iis.getNewsBysearch(map.get("value"));
            List<Object> objList= iis.getAllBysearch(map.get("value"),map.get("variable"));
        return objList;
    }
    @ResponseBody
    @PostMapping("/delet")//适应于三种情况
    public HashMap<String,String> delet(@RequestBody HashMap<String,String> map)//传入类型为map,盲写
    {
        //map.get("value");
        //List<News> newsList=iis.getNewsBysearch(map.get("value"));
        System.out.println(map.get("id")+"::"+map.get("variable"));
        return iis.delet(map.get("id"),map.get("variable"));
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
        //List<Object> objList= iis.getNewsBysearch(map.get("value"),map.get("variable"));

        return iis.setFavor(map.get("id"),map.get("variable"));
    }
    @ResponseBody
    @PostMapping("/showfavor")
    public List<Object>showfavor(@RequestBody HashMap<String,String> map)//传入类型为map
    {
        //String v=null;
        //List<News> newsList=iis.getNewsBysearch(map.get("value"));
        //List<Object> objList= iis.getNewsBysearch(map.get("value"),map.get("variable"));

        return iis.favor(map.get("variable"));
    }
    @ResponseBody
    @GetMapping("/discussshow")
    public List<DiscussContent> showdis()
    {

        return iis.getDis();
    }

    @ResponseBody
    @PostMapping("/showshop")//可扩展到其他方面
    public Shop showshop( @RequestBody HashMap<String,String> map)
    {

        return iis.getAllinformationByShopid(map.get("id"));//id可以是用户名
    }


    @ResponseBody
    @PostMapping("/getfavor")
    public List<Object>shfavor(@RequestBody HashMap<String,String> map)//传入类型为map
    {
        return iis.favor(map.get("variable"));
    }
    @ResponseBody
    @PostMapping("/command")//
    public List<Object> testrecord( @RequestBody HashMap<String,String> map)
    {

        return iis.recommend(map.get("variable"));
    }
}