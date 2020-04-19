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
    public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 角色ID
            */
    private String roleId;

            /**
            * 菜单ID
            */
    private String permissionId;

            /**
            * 1可访问，2可授权
            */
    private String permissionType;


}
