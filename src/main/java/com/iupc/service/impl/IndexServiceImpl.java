package com.iupc.service.impl;

import com.iupc.Mapper.NewsMapper;
import com.iupc.Mapper.ZixunMapper;
import com.iupc.pojo.News;
import com.iupc.pojo.zixun;
import com.iupc.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.zip.DataFormatException;

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

    public List<News> getAllnews() {
       // String formatDate = null;

        return ns.qurryAllNews();
    }

    @Override
    public List<News>getNewsBysearch(String  value) {
            return ns.qurryNewsByContent(value);
    }

    @Override
    public News getNewsById(String value) {
        News news=ns.qurryNewsById(value);
        String[] pic=ns.qurryPicbyId(value);

        for(int i=0;i<pic.length;i++)
        {
            System.out.println(pic[i]);
        }
        news.setNews_pic(pic);
        return news;
    }
}

