package com.jc.dship.pojo;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import java.util.Date;

    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 用户表
    * </p>
*
* @author jc
* @since 2020-04-19
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
    private String id;

            /**
            * 父级id
            */
    private String parentId;

            /**
            * 登录账号
            */
    private String account;

            /**
            * 登录密码
            */
    private String password;

            /**
            * 用户姓名
            */
    private String name;

            /**
            * 用户昵称
            */
    private String nickname;

            /**
            * 用户头像
            */
    private String icon;

            /**
            * 联系电话
            */
    private String phone;

            /**
            * 所属组织
            */
    private String groupId;

            /**
            * 是否禁用 0正常 1禁用
            */
    private Integer forbiddenStatus;

            /**
            * 邮箱
            */
    private String email;

            /**
            * 性别
            */
    private String sex;

            /**
            * 个性签名
            */
    private String gxqm;

            /**
            * 二维码
            */
    private String userQrcode;

            /**
            * 用户OpenID
            */
    private String openId;

            /**
            * 总金额
            */
    private BigDecimal totalMoney;

            /**
            * 可用金额
            */
    private BigDecimal canMoney;

            /**
            * 冻结金额
            */
    private BigDecimal frozenMoney;

            /**
            * 最近登录机器ip地址
            */
    private String loginIp;

            /**
            * 最后一次登录时间
            */
    private Date loginTime;

            /**
            * 创建时间
            */
    private Date createTime;

            /**
            * 更新时间
            */
    private Date updateTime;


}
