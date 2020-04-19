package com.jc.dship.dao;

import com.jc.dship.pojo.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.dship.vo.PermissionTreeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jc
 * @since 2020-04-19
 */
public interface PermissionDao extends BaseMapper<Permission> {

    List<String> selectIdentifierList(@Param("userId") String id);

    List<PermissionTreeVO> selectPermissionList(@Param("userId0") String userId0,@Param("userId1") String userId1);

}
