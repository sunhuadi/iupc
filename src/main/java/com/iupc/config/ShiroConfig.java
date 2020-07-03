package com.iupc.config;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


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
        //自定义过滤器配置
        LinkedHashMap<String, Filter> filtersMap = new LinkedHashMap<>();
        filtersMap.put("roles",  new RoleFilter());
        bean.setFilters(filtersMap);
        //放在前面的权限比较高
       bean.setFilters(filtersMap);


       //开始正常使用
        Map<String, String> filterMap=new LinkedHashMap<>();

        filterMap.put("/upload_news","roles[0,1]");


        //filterMap.put("/upload_news","roles[1]");
        //放行
        filterMap.put("/css/**","anon");//必须在前
        filterMap.put("/fonts/**","anon");//必须在前
        filterMap.put("/image/**","anon");//必须在前
        filterMap.put("/js/**","anon");//必须在前
        filterMap.put("/logins","anon");//必须在前


        //拦截
      // filterMap.put("/**","authc");//必须认证才能访问，
       // filterMap.put("/logins","anon");//必须认证才能访问，
       // filterMap.put("/test/update","authc");



        bean.setFilterChainDefinitionMap(filterMap);
        //设置跳转到登陆页面
        bean.setLoginUrl("/login");

        bean.setUnauthorizedUrl("/unauthorizedUrl");
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

