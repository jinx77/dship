package com.jc.dship.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jc.dship.pojo.User;
import com.jc.dship.service.UserService;
import com.jc.dship.util.MD5Util;
import com.jc.dship.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author jc
 * @since 2019-10-07
 */
@Controller
@RequestMapping(value = {"admin",""})
public class IndexApi {
    //首页
    @RequestMapping(value = {"index",""})
    public String index( Model model){
       User user= UserUtil.getUser();
        model.addAttribute("user",user);
        return "index";
    }
}
