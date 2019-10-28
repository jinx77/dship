package com.jc.dship.service;

import com.jc.dship.pojo.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jc
 * @since 2019-10-13
 */
public interface RoleService extends IService<Role> {

    List<String> selectRoleListUById(String userName);

}
