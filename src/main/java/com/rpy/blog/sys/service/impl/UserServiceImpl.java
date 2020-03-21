package com.rpy.blog.sys.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rpy.blog.sys.mapper.UserMapper;
import com.rpy.blog.sys.domain.User;
import com.rpy.blog.sys.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
