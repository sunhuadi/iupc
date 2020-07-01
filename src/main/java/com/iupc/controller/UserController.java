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
        String userid=user.get("userid");
        String userpassword=user.get("userpassword");
        String role=user.get("role");
        System.out.println("用户名为："+user.get("userid"));
        //System.out.println("密码为："+use);
        if(userid=="")
        {
            mp.put("code","3");
            mp.put("msg","用户名为空，请重新输入。");
            return mp;
        }
        if(role.equals("1"))
        {
            mp=iUserService.testShop(userid,userpassword);
        }
        else {
           mp=iUserService.testUser(userid,userpassword,role);
        }

        return mp;
    }
}
