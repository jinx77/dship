package com.jc.dship.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* <p>
    * 用户表
    * </p>
*
* @author jc
* @since 2019-10-13
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 主键ID
            */
    private String userId;

            /**
            * 父级id
            */
    private String parentId;

            /**
            * 登录账号
            */
    private String userName;

            /**
            * 登录密码
            */
    private String password;

            /**
            * 用户昵称
            */
    private String nickname;

            /**
            * 用户头像
            */
    private String userIcon;

            /**
            * 联系电话
            */
    private String userPhone;

            /**
            * 是否禁用 0正常 1禁用
            */
    private Integer forbiddenStatus;

            /**
            * 邮箱
            */
    private String userEmail;

            /**
            * 性别
            */
    private String userSex;

            /**
            * 个性签名
            */
    private String userGxqm;

            /**
            * 二维码
            */
    private String userQrcode;

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

    private String c;


}
