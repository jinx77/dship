package com.jc.dship.serviceimpl;

import com.jc.dship.pojo.UserRole;
import com.jc.dship.dao.UserRoleDao;
import com.jc.dship.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jc
 * @since 2020-04-19
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

}
