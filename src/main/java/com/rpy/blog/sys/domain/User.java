package com.rpy.blog.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "sys_user")
public class User implements Serializable {
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "loginname")
    private String loginname;

    @TableField(value = "address")
    private String address;

    @TableField(value = "sex")
    private Integer sex;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "pwd")
    private String pwd;

    @TableField(value = "hiredate")
    private Date hiredate;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    @TableField(value = "available")
    private Integer available;

    @TableField(value = "ordernum")
    private Integer ordernum;

    /**
     * 用户类型 0后台管理员   1前端登陆用户
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 头像地址
     */
    @TableField(value = "imgpath")
    private String imgpath;

    @TableField(value = "salt")
    private String salt;

    public static final String COL_NAME = "name";

    public static final String COL_LOGINNAME = "loginname";

    public static final String COL_ADDRESS = "address";

    public static final String COL_SEX = "sex";

    public static final String COL_REMARK = "remark";

    public static final String COL_PWD = "pwd";

    public static final String COL_HIREDATE = "hiredate";

    public static final String COL_EMAIL = "email";

    public static final String COL_AVAILABLE = "available";

    public static final String COL_ORDERNUM = "ordernum";

    public static final String COL_TYPE = "type";

    public static final String COL_IMGPATH = "imgpath";

    public static final String COL_SALT = "salt";
}