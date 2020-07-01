package com.iupc.service.impl;
import com.iupc.Mapper.NewsMapper;
import com.iupc.controller.IndexController;
import com.iupc.pojo.News;
import com.iupc.pojo.NewsPic;
import com.iupc.service.IUploadService;
import com.iupc.util.CommonFileUtil;
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
        if(file==null)
        {
            mp.put("code","0");
            mp.put("msg","封面为空！");
            return mp;
        }
        else
        {
            String path = fileUtil.uploadFile(file);
            news.setNews_img("http://39.97.113.33/"+path);
        }
        if(news.getNews_id()=="")
        {
            mp.put("news_code","0");
            mp.put("news_msg","商品id不能为空");
            return mp;
        }
        String id=Integer.toString(nm.getNewsNumber());
        news.setNews_id(id);
        Timestamp time = new Timestamp(new Date().getTime());
        System.out.println("当前时间为:"+time);
        news.setNews_time(time);
        nm.insertNews(news);
        System.out.println("转换为sql时间为:"+news.getNews_time());

        System.out.println("上传上新时间测试为:"+news.getNews_begintime());
        System.out.println(files.length);
        for(int i=0;i<files.length;i++){
            if(files[i].isEmpty()){
                logger.info("文件不存在");
            }
            String path = fileUtil.uploadFile(files[i]);
            if (path!=null)
            {
                nm.insertNewsPic(new NewsPic("http://39.97.113.33/"+path,news.getNews_id()));
                mp.put("img_code","0");
                mp.put("img_msg","上传第"+i+"张图片成功。");
            }
            System.out.println("http://39.97.113.33/"+path);
        }
        return mp;
    }

}
