package com.iupc.controller;

import com.iupc.Mapper.NewsMapper;
import com.iupc.Mapper.NotesMapper;
import com.iupc.pojo.News;
import com.iupc.pojo.Notes;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {


    @RequestMapping("/test/index")
    public String index()
    {
        return  "test/index";
    }

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
    @RequestMapping("toLogin")
    public String tologin()
    {
        return "test/login";
    }
    @RequestMapping("test/login")
    public String testlogin(String username, String password, Model model)
    {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token =new UsernamePasswordToken(username,password);

        try{
            subject.login(token);//执行登陆方法
            return "test/index";
        }catch (UnknownAccountException e)//用户名不存在
        {
            model.addAttribute("msg","用户不存在");
            return "test/login";
        }catch (IncorrectCredentialsException e)
        {
            model.addAttribute("msg","密码错误");
            return "test/login";
        }

    }
    @ResponseBody
    @RequestMapping("/unauthorizedUrl")
    public String unan()
    {
        return "权限不够，请重试返回";
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
