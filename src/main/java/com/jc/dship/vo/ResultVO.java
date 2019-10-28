package com.jc.dship.vo;

import lombok.Data;

import java.io.Serializable;


/**
 * ResultVO:http 请求返回的最外层对象
 *
 * @author jc
 * @date: 2019/9/23
 */
@Data
public class ResultVO implements Serializable {
    /**
     * 错误码
     */
     private Integer code;
    /**
     * 提示信息
     */
    private String msg;

    /**
     */
     private Object data;

    public static ResultVO ok(String msg,Object data){
        ResultVO r=new ResultVO();
        r.setCode(200);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static ResultVO on(String msg){
        ResultVO r=new ResultVO();
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }

}
