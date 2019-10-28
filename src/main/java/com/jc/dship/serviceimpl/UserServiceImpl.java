package com.jc.dship.serviceimpl;

import com.jc.dship.pojo.User;
import com.jc.dship.dao.UserDao;
import com.jc.dship.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jc
 * @since 2019-10-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
