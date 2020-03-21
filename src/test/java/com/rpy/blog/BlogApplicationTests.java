package com.rpy.blog;

import com.rpy.blog.sys.constant.Constant;
import com.rpy.blog.sys.domain.Menu;
import com.rpy.blog.sys.mapper.MenuMapper;
import com.rpy.blog.sys.utils.MD5Utils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private MenuMapper menuMapper;


    @Test
    void select(){
        List<Menu> menus = menuMapper.selectList(null);
        System.out.println(menus);
    }

    @Test
    void md5(){
        String uuid = MD5Utils.createUUID();
        String s = MD5Utils.md5("123456", uuid, 2);

        System.out.println(uuid);
        System.out.println(s);
    }


    @Test
    void contextLoads() {
        /**第一层**/
        menuMapper.insert(new Menu(1,0, Constant.TYPE_MENU,"常规管理",null,"fa fa-cogs",null,"_self",Constant.OPEN_TRUE,1,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(2,0, Constant.TYPE_MENU,"博客管理",null,"fa fa-drupal",null,"_self",Constant.OPEN_TRUE,2,Constant.AVAILABLE_TRUE));

        /**第二层**/
        /**常规部分*/
        menuMapper.insert(new Menu(3,1, Constant.TYPE_MENU,"系统管理",null,"fa fa-cog",null,"_self",Constant.OPEN_TRUE,3,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(4,1, Constant.TYPE_MENU,"菜单管理",null,"fa fa-cog",null,"_self",Constant.OPEN_TRUE,4,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(5,1, Constant.TYPE_MENU,"数据源管理",null,"fa fa-cog",null,"_target",Constant.OPEN_TRUE,5,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(6,1, Constant.TYPE_MENU,"公告管理",null,"fa fa-cog",null,"_self",Constant.OPEN_TRUE,6,Constant.AVAILABLE_TRUE));

        /**第二层**/
        /**博客部分*/
        menuMapper.insert(new Menu(7,2, Constant.TYPE_MENU,"文章管理",null,"fa fa-mortar-board",null,"_self",Constant.OPEN_TRUE,7,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(8,2, Constant.TYPE_MENU,"评论管理",null,"fa fa-mortar-board",null,"_self",Constant.OPEN_TRUE,8,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(9,2, Constant.TYPE_MENU,"留言管理",null,"fa fa-mortar-board",null,"_self",Constant.OPEN_TRUE,9,Constant.AVAILABLE_TRUE));


        /***第三层**/
        /**系统管理部分**/
        menuMapper.insert(new Menu(10,3, Constant.TYPE_MENU,"用户查询",null,"fa fa-cog",null,null,Constant.OPEN_TRUE,10,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(11,3, Constant.TYPE_MENU,"登陆日志管理",null,"fa fa-cog",null,null,Constant.OPEN_TRUE,11,Constant.AVAILABLE_TRUE));

        /**菜单管理部分**/
        menuMapper.insert(new Menu(12,4, Constant.TYPE_MENU,"菜单查询",null,"fa fa-cog",null,null,Constant.OPEN_TRUE,12,Constant.AVAILABLE_TRUE));


        /**文章管理部分**/
        menuMapper.insert(new Menu(13,7, Constant.TYPE_MENU,"文章查询",null,"fa fa-cog",null,null,Constant.OPEN_TRUE,13,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(14,7, Constant.TYPE_MENU,"标签查询",null,"fa fa-cog",null,null,Constant.OPEN_TRUE,14,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(15,7, Constant.TYPE_MENU,"类别查询",null,"fa fa-cog",null,null,Constant.OPEN_TRUE,15,Constant.AVAILABLE_TRUE));

        /**评论管理部分**/
        menuMapper.insert(new Menu(16,8, Constant.TYPE_MENU,"评论查询",null,"fa fa-cog",null,null,Constant.OPEN_TRUE,16,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(17,8, Constant.TYPE_MENU,"评论审批",null,"fa fa-cog",null,null,Constant.OPEN_TRUE,17,Constant.AVAILABLE_TRUE));
        /**留言管理部分**/
        menuMapper.insert(new Menu(18,9, Constant.TYPE_MENU,"留言查询",null,"fa fa-cog",null,null,Constant.OPEN_TRUE,18,Constant.AVAILABLE_TRUE));
        menuMapper.insert(new Menu(19,9, Constant.TYPE_MENU,"留言审批",null,"fa fa-cog",null,null,Constant.OPEN_TRUE,19,Constant.AVAILABLE_TRUE));
    }

}
