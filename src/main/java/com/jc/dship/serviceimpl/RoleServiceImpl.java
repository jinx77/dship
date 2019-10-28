package com.jc.dship.serviceimpl;

import com.jc.dship.pojo.Role;
import com.jc.dship.dao.RoleDao;
import com.jc.dship.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jc
 * @since 2019-10-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public List<String> selectRoleListUById(String userName) {
        return roleDao.selectRoleListUById(userName);
    }
}
