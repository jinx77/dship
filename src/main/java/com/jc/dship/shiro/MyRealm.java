package com.jc.dship.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jc.dship.pojo.User;
import com.jc.dship.service.RoleService;
import com.jc.dship.service.UserService;
import com.jc.dship.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author jc
 * @create 2019-09-12 15:23
 * @desc
 **/
@Slf4j
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private RoleService roleService;
    @Autowired
    UserService userService;

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    /*@Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;

    }*/

    /**
     * 执行授权逻辑
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("执行授权逻辑");
        //1、获取登录时输入的用户名
     //   String loginName=(String) principals.fromRealm(getName()).iterator().next();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<String> roleList= roleService.selectRoleListUById(user.getUserName());
        //查询所拥有的角色
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleList);



       /* String username = JwtUtil.getUsername(principals.toString());
        //根据用户名查询权限
        List<Resource> resourceList = adminUserService.selectResource(username);
        resourceList.parallelStream().forEach(resource ->
                simpleAuthorizationInfo.addStringPermission(resource.getResourceName())
        );*/
        return info;

    }

    /**
     *
     *执行认证逻辑
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {





        System.out.println("执行登录认证逻辑");

        UsernamePasswordToken token=(UsernamePasswordToken)auth;

        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.eq("user_name",token.getUsername());
        User user=userService.getOne(userQueryWrapper);
       if (user==null){
           throw new UnknownAccountException("你输入的用户名不存在");
       }
       if (user.getForbiddenStatus()==1){
           throw new LockedAccountException("该用户已被禁止登陆");
       }
       Object credentials=user.getPassword();
      return new SimpleAuthenticationInfo(user,credentials,super.getName());

    }
}




