package com.iupc.config;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactory
    //DefaoutWEbSecurityManage
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager)
    {
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shito的内置过滤器
        /*anon无需认证
        *authc：必须认证
        *user:必须拥有记住我功能才能用
        * perms：拥有对某个资源的权限才能访问
        * role：拥有某个角色权限才能访问
        * */

        Map<String, String> filterMap=new LinkedHashMap<>();
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager =new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建realman对象
    @Bean
    public UserRealm userRealm()
    {
        return new UserRealm();
    }
}
