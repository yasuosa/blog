package com.rpy.blog.sys.shiro.reaml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rpy.blog.sys.common.ActiviUser;
import com.rpy.blog.sys.domain.User;
import com.rpy.blog.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * @Auther 任鹏宇
 * @Date 2020/3/21
 */
public class UserRealm extends AuthorizingRealm {


    @Autowired
    @Lazy
    private UserService userService;


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginname= (String) authenticationToken.getPrincipal();
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("loginname",loginname);
        User user = userService.getOne(queryWrapper);
        ActiviUser activiUser=null;
        if(null != user){
            activiUser=new ActiviUser();
            ByteSource byteSource=ByteSource.Util.bytes(user.getSalt());
            activiUser.setUser(user);
            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(activiUser,user.getPwd(),byteSource,this.getName());
            return info;
            //TODO 权限 角色 代做
        }
        return null;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
