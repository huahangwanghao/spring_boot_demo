package com.wanghao.spring.boot.aop;/**
 * Created by Administrator on 2017/4/26.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP的应用
 *Component:进行spring管理这个类
 * @author WangH
 * @create 2017-04-26 11:13
 **/
@Aspect
@Component
public class HttpAspectJ {
    
    protected  static Logger logger= LoggerFactory.getLogger(HttpAspectJ.class);
    
    @Pointcut("execution(public * com.wanghao.spring.boot..*(..))")
    public void log(){}
    
    
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("this is before");
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=requestAttributes.getRequest();
        //url
        StringBuffer url=request.getRequestURL();
        logger.info("url={}",url);
        //method  get/post
        String method=request.getMethod();
        logger.info("method={}",method);
        //ip
        String ip=request.getRemoteAddr();
        logger.info("ip={}",ip);
        //访问的类.方法名
        String className=joinPoint.getSignature().getDeclaringTypeName();
        String classMethod=joinPoint.getSignature().getName();
        logger.info("调用类的方法{}",className+"."+classMethod);
        //参数
        logger.info("获取到的参数={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
      //  logger.info("this is after");
    }
    
    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterReturn(Object object){
        logger.info("返回的内容={}",object);
    }

}
