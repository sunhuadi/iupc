package com.iupc.controller;

import com.alibaba.fastjson.JSON;
import com.iupc.pojo.News;
import com.iupc.pojo.Users;
import com.iupc.service.IUploadService;
import com.iupc.util.CommonFileUtil;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private CommonFileUtil fileUtil;

    @Autowired
    private IUploadService ius;
    @ResponseBody
    @PostMapping("/uploadNews")
    public HashMap<String,String> uploadNews(@RequestParam("myfiles") MultipartFile[] files,
                                             @RequestParam("myfile") MultipartFile file,
                                             @RequestPart Map<String, Object> news) throws IOException {
        System.out.println("已经接受请求，正在处理......");
        News useNews = JSON.parseObject(JSON.toJSONString(news), News.class);
        System.out.println(useNews);
        //News useNews = new News();
        return ius.upload_news(files,file,useNews);
    }

    @ResponseBody
    @PostMapping("/upregister")
    public HashMap<String,String> uploadUser(
                                             @RequestParam("myfile") MultipartFile file,
                                             @RequestPart Map<String, Object> user) throws IOException {
        System.out.println("已经接受请求，正在处理......");
        Users cuser = JSON.parseObject(JSON.toJSONString(user), Users.class);
        System.out.println(cuser);
        //News useNews = new News();
        return ius.upload_user(file,cuser);
    }


}
