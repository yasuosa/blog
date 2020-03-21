package com.rpy.blog.sys.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rpy.blog.sys.domain.Menu;
import com.rpy.blog.sys.mapper.MenuMapper;
import com.rpy.blog.sys.service.MenuService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}

