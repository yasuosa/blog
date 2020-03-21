package com.rpy.blog.sys.common;

import com.rpy.blog.sys.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther 任鹏宇
 * @Date 2020/3/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiviUser implements Serializable {

    private User user;

    private List<String> roles;

    private List<String> permissions;
}
