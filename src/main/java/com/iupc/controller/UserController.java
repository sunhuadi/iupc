package com.iupc.controller;

import com.iupc.Mapper.UsersMapper;
import com.iupc.pojo.Users;
import com.iupc.service.IUserService;
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
    IUserService iUserService;
    @ResponseBody
    @PostMapping("/logins")
    public HashMap<String,String> Test(@RequestBody HashMap<String,String> user)
    {
        HashMap<String,String> mp=new HashMap<String,String>();
        System.out.println("收到请求，正在确认......");
        String username=user.get("username");
        String password=user.get("password");
        String role=user.get("role");
        System.out.println("用户名为："+user.get("username"));
        //System.out.println("密码为："+use);
        if(username=="")
        {
            mp.put("code","3");
            mp.put("msg","用户名为空，请重新输入。");
            return mp;
        }
         mp=iUserService.testUser(username,password);


        return mp;
    }
}
