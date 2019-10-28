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
* @since 2019-10-13
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键id
            */
    private String roleId;

            /**
            * 角色名称
            */
    private String roleName;

            /**
            * 备注
            */
    private String remarks;


}
