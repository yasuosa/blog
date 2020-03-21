package com.rpy.blog.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.rpy.blog.sys.common.ActiviUser;
import com.rpy.blog.sys.common.ResultObj;
import com.rpy.blog.sys.constant.Constant;
import com.rpy.blog.sys.domain.User;
import com.rpy.blog.sys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther 任鹏宇
 * @Date 2020/3/21
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResultObj login(String loginname,String password,String keyCode,String captcha){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();

        System.out.println(keyCode);
        String oldCaptcha = opsForValue.get(Constant.CODE_REDIS_KEY_STIFF+keyCode);
        if(null == oldCaptcha){
            return ResultObj.LOGIN_FAIL.setMsg(Constant.LOGIN_WRONG_CAPTCH_TIME);
        }
        if(!captcha.equals(oldCaptcha)){
            return ResultObj.LOGIN_FAIL.setMsg(Constant.LOGIN_WRONG_CAPTCH);
        }
        Map<String,Object> map=new HashMap<>();
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token=new UsernamePasswordToken(loginname,password);
            subject.login(token);
            ActiviUser activiUser= (ActiviUser) subject.getPrincipal();
            User user = activiUser.getUser();
            map.put("token",subject.getSession().getId());
            map.put("name",user.getName());
            //删除已经验证后的验证码
            redisTemplate.delete(keyCode);
            return ResultObj.LOGIN_SUCCESS.addData(map);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultObj.LOGIN_FAIL;
        }
    }

    @RequestMapping(value = "getCode",method = RequestMethod.GET)
    public void getCode(String keyCode, HttpServletResponse response) throws IOException {
        ValueOperations<String, String> opsForValue= redisTemplate.opsForValue();
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(110, 40,4,2);
        //将验证码code值 存入redis
        opsForValue.set(Constant.CODE_REDIS_KEY_STIFF+keyCode,lineCaptcha.getCode(), Duration.ofMinutes(1));
        lineCaptcha.write(response.getOutputStream());
    }


}
