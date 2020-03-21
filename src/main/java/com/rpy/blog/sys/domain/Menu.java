package com.rpy.blog.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "sys_menu")
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "pid")
    private Integer pid;

    /**
     * 权限类型[menu/permission]
     */
    @TableField(value = "type")
    private String type;

    @TableField(value = "title")
    private String title;

    /**
     * 权限编码[只有type= permission才有  user:view]
     */
    @TableField(value = "percode")
    private String percode;

    @TableField(value = "icon")
    private String icon;

    @TableField(value = "href")
    private String href;

    @TableField(value = "target")
    private String target;

    @TableField(value = "open")
    private Integer open;

    @TableField(value = "ordernum")
    private Integer ordernum;

    /**
     * 状态【0不可用1可用】
     */
    @TableField(value = "available")
    private Integer available;

    public static final String COL_PID = "pid";

    public static final String COL_TYPE = "type";

    public static final String COL_TITLE = "title";

    public static final String COL_PERCODE = "percode";

    public static final String COL_ICON = "icon";

    public static final String COL_HREF = "href";

    public static final String COL_TARGET = "target";

    public static final String COL_OPEN = "open";

    public static final String COL_ORDERNUM = "ordernum";

    public static final String COL_AVAILABLE = "available";
}