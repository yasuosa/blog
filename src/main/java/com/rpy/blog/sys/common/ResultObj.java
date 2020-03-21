package com.rpy.blog.sys.common;

import com.rpy.blog.sys.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther 任鹏宇
 * @Date 2020/3/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {

    private Integer code;
    private String msg;
    private Object data;


    public static ResultObj LOGIN_SUCCESS=new ResultObj(200, Constant.LOGIN_SUCCESS,null);
    public static final ResultObj LOGIN_FAIL =new ResultObj(-1, Constant.LOGIN_FAIL,null); ;


    public ResultObj addData(Object data){
        this.data=data;
        return this;
    }

    public ResultObj setMsg(String msg){
        this.msg=msg;
        return this;
    }

}
