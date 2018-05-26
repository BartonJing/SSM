package com.barton.utils;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.barton.domain.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 项目名称：ssm
 * 创建人：景荣荣
 * 创建时间： 2018-4-24
 * 描述：Session 工具类
 */
public class SessionUtil {
    private static final Log log = LogFactory.get();
    /**
     * session存放用户信息key
     */
    public static String SESSION_USER = "SESSION_USER";

    /**
     * 获取登录用户
     * @return
     */
    public static User getLoginUser(){
        User loginUser = (User) getSessionValue(SESSION_USER);
        return loginUser;
    }


    /**
     * 设置session变量
     * @return
     */
    public static void setSessionValue(String key,Object value){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.getSession().setAttribute(key,value);
    }

    /**
     * 获取session变量
     * @return
     */
    public static Object getSessionValue(String key){
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.getSession().getAttribute(key);
    }



}
