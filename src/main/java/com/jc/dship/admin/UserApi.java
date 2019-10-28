package com.jc.dship.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jc.dship.pojo.User;
import com.jc.dship.service.UserService;
import com.jc.dship.util.MD5Util;
import com.jc.dship.util.UserUtil;
import com.jc.dship.vo.UserVO;
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
@RequestMapping("admin/user")
public class UserApi {

    @Autowired
    UserService userService;
    @RequestMapping("list")
    public ModelAndView list(){
       User user= UserUtil.getUser();
       System.out.println("user---"+user.toString());
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("parent_id",user.getUserId());
        List<User> userList= userService.list(queryWrapper);

        userList.forEach(userVO -> System.out.println(userVO.toString()));
        ModelAndView m=new ModelAndView();
        m.addObject("userList",userList);
        m.setViewName("user/list");
        return m;
    }

    //测试
    @RequestMapping("jc")
    public String jc(){
        return "user/jc";
    }

    //登录页面
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }
    //未授权页面
    @RequestMapping("unAuth")
    public String unAuth(){
        return "unAuth";
    }
    //首页
    @RequestMapping("index")
    public String index( Model model){
       User user= UserUtil.getUser();
        model.addAttribute("user",user);
        return "index";
    }
    //登录接口
    @RequestMapping("login")
    public String login(User user, Model model){

        String password= MD5Util.getMD5Sign(user.getUserName(),user.getPassword());
        /**
         * 使用Shiro编写认证操作
         *
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(),password);

        //3.执行登录方法
        try {
            subject.login(token);
            return "redirect:/admin/user/index";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            //登录失败:用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (LockedAccountException e){
            e.printStackTrace();
            //登录失败:用户名不存在
            model.addAttribute("msg",e.getMessage());
            return "login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            //登录失败:密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
    //登出
    @RequestMapping("logout")
    public String logout(Model model){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg","已成功退出");
        return "login";
    }

}
