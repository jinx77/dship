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
    public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 用户主键ID
            */
    private String userId;

            /**
            * 角色主键ID
            */
    private String roleId;


}
