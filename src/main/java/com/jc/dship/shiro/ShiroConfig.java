package com.jc.dship.shiro;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author jc
 *   @create 2019-09-12 15:23
 *     @desc
 *
 *  Subject:  用户主体（把操作交给SecurityManager）
 *
 *  SecurityManager： 安全管理器（关联Realm）
 *
 *  Realm： Shiro连接数据的桥梁
 *
 */
//把此类作为一个配置类
@Configuration
public class ShiroConfig {
    /**
     *  创建ShiroFilterFactoryBean
     *
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器

        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *     常用的过滤器：
         *        anon：无需认证（登录）可以访问
         *        authc：必须认证才可以访问
         *        user：如果使用rememberMe的功能可以直接访问
         *        perms：该资源必须得到角色权限才可以访问
         */

        Map<String,String> filterMap= new LinkedHashMap<>();
        //放行login.html页面
        filterMap.put("login","anon");
        filterMap.put("/admin/user/login","anon");

        //静态资源放行
        filterMap.put("/layui/**","anon");
        filterMap.put("/login/**","anon");

        filterMap.put("/**","authc");
        //修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("/admin/user/toLogin");
        //设置未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/admin/user/unAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     *   创建DefaultWebSecurityManager
     *   @Qualifier 可以得到Spring容器里的对象
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    /**
     *  创建Realm
     *  @Bean 把返回的对象放到Spring容器里
     */
    @Bean
    public Realm getRealm(){

        return new MyRealm();

    }

}
