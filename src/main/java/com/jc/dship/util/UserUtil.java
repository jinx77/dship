package com.jc.dship.util;

import com.jc.dship.pojo.User;
import com.jc.dship.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class UserUtil {
    @Autowired
   static UserService userService;
    public static User getUser(){
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println("user----" +user.toString());

        return user;
    }

}
