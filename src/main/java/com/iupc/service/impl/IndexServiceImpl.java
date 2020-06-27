package com.iupc.service.impl;

import com.iupc.Mapper.NewsMapper;
import com.iupc.Mapper.ZixunMapper;
import com.iupc.pojo.News;
import com.iupc.pojo.zixun;
import com.iupc.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
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
            zxlist.get(i).setFormattime(DateFormat.getDateInstance(DateFormat.FULL).format(zxlist.get(i).getTime()));
            // System.out.println(zxlist.get(i).getFormattime());
        }
        return zxlist;
    }

    public List<News> getAllnews() {
        String formatDate = null;
        List<News> newsList = ns.qurryAllNews();
        for (int i = 0; i < newsList.size(); i++) {
            newsList.get(i).setNews_formattime(DateFormat.getDateInstance(DateFormat.FULL).format(newsList.get(i).getNews_time()));
        }
        return newsList;
    }

    @Override
    public List<News> getNewsBysearch(String value) {
            List<News> newsList=ns.qurryNewsByContent(value);
        for (int i = 0; i < newsList.size(); i++) {
            newsList.get(i).setNews_formattime(DateFormat.getDateInstance(DateFormat.FULL).format(newsList.get(i).getNews_time()));
        }
            return newsList;
    }
}

