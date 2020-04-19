package com.jc.dship.admin;


import com.google.inject.internal.util.$Lists;
import com.jc.dship.pojo.User;
import com.jc.dship.service.PermissionService;
import com.jc.dship.util.UserUtil;
import com.jc.dship.vo.PermissionTreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jc
 * @since 2020-04-19
 */
@RestController
@RequestMapping("admin/permission")
public class PermissionApi {
    @Autowired
    PermissionService permissionService;
    //首页
    @RequestMapping(value = "select")
    public List<PermissionTreeVO> select(String userId){
        return permissionService.selectPermissionList(userId);
    }

}
