package com.wanghao.spring.boot.listener;/**
 * Created by Administrator on 2017/5/24.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听Session的创建与销毁
 *
 * @author   单红宇(365384722)
 * @myblog  http://blog.csdn.net/catoop/
 * @create    2016年1月6日
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    protected static Logger logger= LoggerFactory.getLogger(MyHttpSessionListener.class);
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("Session 被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("ServletContex初始化");
    }

}