package com.wanghao.spring.boot.aop;/**
 * Created by Administrator on 2017/4/26.
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
    
    @Pointcut("execution(com.wanghao.spring.boot.service..*(..))")
    public void log(){}
    
    
    @Before("@log()")
    public void beforeLog(){
    
    }
    
    
}
