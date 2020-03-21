package com.rpy.blog.sys.constant;

public interface Constant {

    /**后台管理员**/
    Integer USER_ADMIN_TYPE=0;
    /**前端用员**/
    Integer USER_NORMAL_TYPE=1;


    String TYPE_MENU="menu";
    String TYPE_PERMISSION="permission";

    /**是否展开**/
    Integer OPEN_TRUE=1;
    Integer OPEN_FLASE=0;

    /**是否可用**/
    Integer AVAILABLE_TRUE=1;
    Integer AVAILABLE_FALSE=0;


    String LOGIN_SUCCESS="登陆成功";
    String LOGIN_FAIL="登陆失败|密码错误";
    String LOGIN_WRONG_CAPTCH="登陆失败|验证码错误";
    String LOGIN_WRONG_CAPTCH_TIME="登陆失败|验证码失效";

    String CODE_REDIS_KEY_STIFF="code::captcha::";

}
