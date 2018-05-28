package com.barton.security;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 项目名称：ssm
 * 创建时间：2018-04-25
 * 描述: 会话监听器
 */
public class MySessionListener implements SessionListener {

    private static Logger logger = LoggerFactory.getLogger(MySessionListener.class);


    @Override
    public void onStart(Session session) {
        logger.info("会话创建: " + session.getId());
    }

    @Override
    public void onStop(Session session) {
        logger.info("会话停止：" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        logger.info("会话过期：" + session.getId());
    }
}
