package com.iupc.controller;

import com.iupc.Mapper.UsersMapper;
import com.iupc.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UsersMapper usersMapper;
    @ResponseBody
    @PostMapping("/logins")
    public HashMap<String,String> Test(@RequestBody Users user)
    {
        HashMap<String,String> mp=new HashMap<String,String>();
        System.out.println("收到请求，正在确认......");
        System.out.println("用户名为："+user.getUserid());
        if(user.getUserid()=="")
        {
            mp.put("code","3");
            mp.put("msg","用户名为空，请重新输入。");
            return mp;
        }

        Users users=usersMapper.getUserByName(user);
      //  System.out.println("该用户和密码为："+user.getUserid()+user.getUserpassword());
        //System.out.println("数据库中该用户和密码为："+users.getUserid()+users.getUserpassword());
     if(users==null)
    {
        mp.put("code","1");
        mp.put("msg","用户不存在，请重新输入。");
    }
     else if(users.getUserpassword().equals(user.getUserpassword()))
        {
            mp.put("code","0");
            mp.put("msg","密码正确，登陆成功。");
        }
        else if(users==null)
        {
            mp.put("code","1");
            mp.put("msg","用户不存在，请重新输入。");
        }
        else
        {
            mp.put("code","2");
            mp.put("msg","密码错误，请重新输入密码。");
        }
        return mp;
    }
}
