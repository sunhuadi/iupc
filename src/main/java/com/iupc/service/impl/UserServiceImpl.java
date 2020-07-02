package com.iupc.service.impl;

import com.iupc.Mapper.UsersMapper;
import com.iupc.pojo.Shop;
import com.iupc.pojo.Users;
import com.iupc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Service("UserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UsersMapper usersMapper;


    public HashMap<String,String> testUser(String username,String password)
    {
        HashMap<String,String> mp=new HashMap<String,String>();
        Users users=usersMapper.getUserByName(username);
        if(users==null)//用户名为空
        {
            mp.put("code","1");
            mp.put("msg","用户不存，请重新尝试。");
        }
        else if(users.getPassword().equals(password))
        {//登陆成功
                mp.put("code","0");
                mp.put("msg","密码正确，登陆成功。");
                mp.put("role",users.getRole());
                mp.put("username",users.getUsername());
                mp.put("img",users.getPortrait());
                mp.put("name",users.getName());
        }
        else//密码错误
        {
            mp.put("code","2");
            mp.put("msg","密码错误，请重新输入密码。");
        }
        return mp;
    }
}


