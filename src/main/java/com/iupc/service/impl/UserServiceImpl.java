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


    public HashMap<String,String> testUser(String userid,String userpassword,String role)
    {
        HashMap<String,String> mp=new HashMap<String,String>();
        Users users=usersMapper.getUserByName(userid);
        if(users==null)
        {
            mp.put("code","1");
            mp.put("msg","用户不存在或身份选择错误，请重新尝试。");
        }
        else if(users.getUserpassword().equals(userpassword))
        {
            System.out.println("密码正确,等待验证身份！");
            if(users.getRole().equals(role))
            {
                mp.put("code","0");
                mp.put("msg","密码正确，登陆成功。");
                mp.put("role",users.getRole());
                mp.put("username",users.getUserid());
                mp.put("img",users.getPortrait());
                mp.put("name",users.getUsername());
            }
            else {
                mp.put("code","1");
                mp.put("msg","用户不存在或身份选择错误，请重新尝试。");
            }

        }
        else
        {
            mp.put("code","2");
            mp.put("msg","密码错误，请重新输入密码。");
        }
        return mp;
    }


    public HashMap<String,String> testShop(String userid,String userpassword)
    {
        HashMap<String,String> mp=new HashMap<String,String>();
        Shop users=usersMapper.getShopByName(userid);
        System.out.println("正在查询店家信息！");
        //System.out.println(users.getShop_name());
        if(users==null)
        {
            mp.put("code","1");
            mp.put("msg","用户不存在或身份选择错误，请重新尝试。");
        }
        else if(users.getShop_password().equals(userpassword))
        {
            mp.put("code","0");
            mp.put("msg","密码正确，登陆成功。");
            mp.put("role",users.getRole());
            mp.put("username",users.getShop_id());
            mp.put("img",users.getShop_pic());
            mp.put("name",users.getShop_name());

        }
        else
        {
            mp.put("code","2");
            mp.put("msg","密码错误，请重新输入密码。");
        }
        return mp;
    }

}
