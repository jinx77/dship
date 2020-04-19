package com.jc.dship.pojo;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author jc
* @since 2020-04-19
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;


            /**
            * 标识符
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


}
