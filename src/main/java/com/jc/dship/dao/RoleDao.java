package com.jc.dship.dao;

import com.jc.dship.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jc
 * @since 2019-10-13
 */
public interface RoleDao extends BaseMapper<Role> {

    List<String> selectRoleListUById(String userName);
}
