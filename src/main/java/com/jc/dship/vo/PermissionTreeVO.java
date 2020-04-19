package com.jc.dship.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
* <p>
    * 
    * </p>
*
* @author jc
* @since 2020-04-19
*/
    @Data
    public class PermissionTreeVO implements Serializable {

    private static final long serialVersionUID = 1L;
            /**
            * id
            */
    private String id;
            /**
            * 标识符
            */
    private String identifier;

            /**
            * 父级ID
            */
    private String parentId;

            /**
            * 所有父级ID
            */
    private String parentIds;

            /**
            * 菜单名称
            */
    private String name;

            /**
            * 链接
            */
    private String href;

            /**
            * 图标
            */
    private String icon;

            /**
            * 排序
            */
    private Integer sort;
            /**
            * 选中状态  1 选中 2未选中
            */
    private Integer hook;


    private List<PermissionTreeVO> permissionTreeVOList;


}
