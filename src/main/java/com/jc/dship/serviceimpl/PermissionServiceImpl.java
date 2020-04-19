package com.jc.dship.serviceimpl;

import com.jc.dship.pojo.Permission;
import com.jc.dship.dao.PermissionDao;
import com.jc.dship.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.dship.util.UserUtil;
import com.jc.dship.vo.PermissionTreeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jc
 * @since 2020-04-19
 */
@Slf4j
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements PermissionService {
    @Autowired
    PermissionDao permissionDao;
    //获取权限tree
    @Override
    public List<PermissionTreeVO> selectPermissionList(String id) {

        List<PermissionTreeVO> permissionTreeVOList0= permissionDao.selectPermissionList(UserUtil.getUser().getId(),id);
        List<PermissionTreeVO> permissionTreeVOList= new ArrayList<>();
            log.info(permissionTreeVOList.toString());
        permissionTreeVOList0.forEach(permissionTreeVO -> {
            if (permissionTreeVO.getParentId()==null||"".equals(permissionTreeVO.getParentId())){
                permissionTreeVOList.add(permissionTreeVO);
            }
        });
        return tree(permissionTreeVOList,permissionTreeVOList0);
    }
    public List<PermissionTreeVO> tree(List<PermissionTreeVO> permissionTreeVOList,List<PermissionTreeVO> permissionTreeVOList0) {
        permissionTreeVOList.forEach(permissionTreeVO -> {
            List<PermissionTreeVO> pTVL=new ArrayList<>();
            permissionTreeVOList0.forEach(permission -> {
               if (permission.getParentId()!=null&&!"".equals(permission.getParentId())&&permissionTreeVO.getId().equals(permission.getParentId())){
                   PermissionTreeVO pTV =new PermissionTreeVO();
                   BeanUtils.copyProperties(permission,pTV);
                   pTVL.add(pTV);
               }
           });
            permissionTreeVO.setPermissionTreeVOList(pTVL);
            tree(pTVL,permissionTreeVOList0);
        });
        return permissionTreeVOList;
    }
}
