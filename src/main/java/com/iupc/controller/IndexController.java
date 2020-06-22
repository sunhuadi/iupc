package com.iupc.controller;

import com.iupc.Mapper.ZixunMapper;
import com.iupc.pojo.zixun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ZixunMapper zx;
    @GetMapping("/")
    public String index(Model model)
    {
        String formatDate = null;
        System.out.println("ok?");
        List<zixun> zxlist=zx.qurryzixunall();
        for (int i=0;i<zxlist.size();i++)
        {
            zxlist.get(i).setFormattime(DateFormat.getDateInstance(DateFormat.FULL).format(zxlist.get(i).getTime()));
            System.out.println(zxlist.get(i).getFormattime());
        }

        model.addAttribute("zxlist",zxlist);

        return "index";
    }
}
