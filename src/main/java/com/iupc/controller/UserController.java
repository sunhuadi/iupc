package com.iupc.controller;

import com.iupc.Mapper.UsersMapper;
import com.iupc.pojo.Users;
import com.iupc.service.IUserService;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        String username=user.get("username");
        String password=user.get("password");
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token =new UsernamePasswordToken(username,password);
        try{
            subject.login(token);//执行登陆方法
            Subject subject1 = SecurityUtils.getSubject();
            Users currentUser=(Users) subject1.getPrincipal();
            mp.put("code","0");
            mp.put("msg","密码正确，登陆成功。");
            mp.put("role",currentUser.getRole());
            mp.put("username",currentUser.getUsername());
            mp.put("img",currentUser.getPortrait());
            mp.put("name",currentUser.getShowname());
            ///System.out.println(currentUser.getPassword());
            return mp;
        }catch (UnknownAccountException e)//用户名不存在
        {
            mp.put("code","1");
            mp.put("msg","该用户不存在，请重新输入。");
            return mp;
        }catch (IncorrectCredentialsException e)
        {
            mp.put("code","2");
            mp.put("msg","密码错误，请重新输入密码。");
            return mp;
        }
        /*
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

*/
    }
    @ResponseBody
    @GetMapping("getUser")
    public Users getUsernow()
    {
        Subject subject1 = SecurityUtils.getSubject();
        Users currentUser=(Users) subject1.getPrincipal();
        currentUser.setPassword("**********");
        return currentUser;
    }
}
