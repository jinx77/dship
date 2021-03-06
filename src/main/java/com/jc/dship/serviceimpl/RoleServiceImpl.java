package com.jc.dship.serviceimpl;

import com.jc.dship.pojo.Role;
import com.jc.dship.dao.RoleDao;
import com.jc.dship.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

}
