package com.wanghao.spring.boot.aop;/**
 * Created by Administrator on 2017/4/26.
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * AOP的应用
 *
 * @author WangH
 * @create 2017-04-26 11:13
 **/
@Aspect
public class HttpAspectJ {
    
    @Pointcut("execution(com.wanghao.spring.boot.service..*(..))")
    public void log(){}
    
    
    
    
}
