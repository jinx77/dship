package com.jc.dship.service;

import com.jc.dship.pojo.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jc.dship.vo.PermissionTreeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jc
 * @since 2020-04-19
 */
public interface PermissionService extends IService<Permission> {

    List<PermissionTreeVO> selectPermissionList(String id);

}
