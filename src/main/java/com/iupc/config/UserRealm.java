package com.iupc.config;

import com.iupc.Mapper.UsersMapper;
import com.iupc.pojo.Users;
import com.iupc.service.IUserService;
import org.apache.catalina.filters.ExpiresFilter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.w3c.dom.ls.LSOutput;

public class UserRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("执行授权");
        //授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addRole("1");
        //拿到当前登陆对象
        Subject subject = SecurityUtils.getSubject();
       Users currentUser=(Users) subject.getPrincipal();
       //设置当前用户的权限
       info.addRole(currentUser.getRole());
        return info;
    }
@Autowired
    UsersMapper usersMapper;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证");
        //用户名密码数据库获取
        //String name="root";
       // String password="123456";
        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
        Users users= usersMapper.getUserByName(usertoken.getUsername());
        if(users==null){//用户不存在
            return null;
        }//密码认证shiro做,加密
        //System.out.println(users.getPassword());
        return new SimpleAuthenticationInfo(users,users.getPassword(),"");
    }
}
