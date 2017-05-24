package com.wanghao.spring.boot.filter;/**
 * Created by Administrator on 2017/5/24.
 */

import com.wanghao.spring.boot.bean.ResultBean;
import com.wanghao.spring.boot.enumtype.EnumType;
import com.wanghao.spring.boot.service.RedisService;
import com.wanghao.spring.boot.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用注解标注过滤器
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 *
 * @author   单红宇(365384722)
 * @myblog  http://blog.csdn.net/catoop/
 * @create    2016年1月6日
 */
@WebFilter(filterName="myFilter",urlPatterns="*.do")
public class MyFilter implements Filter {
    protected static Logger logger= LoggerFactory.getLogger(MyFilter.class);
    @Autowired
    private RedisService redisService;
    @Override
    public void destroy() {
        logger.info("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest)request;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        StringBuffer url=req.getRequestURL();
        String token=req.getHeader("token");
        logger.info("myFilter url is --------->"+url);
        if(isPass(url.toString())){
            //如果是登录接口,不用校验token的问题,直接放行
           
            chain.doFilter(request, response);
        }else{
            logger.info("执行过滤操作");
            logger.info("myFilter token is --------->"+token);
            ResultBean resultBean=new ResultBean();
            if(StringUtils.isEmpty(token)){
                //如果没有上传token这个值
                 resultBean=ResultUtils.error(EnumType.SYSTEMERROR);
                 logger.info("未通过过滤器,返回给前台数据:"+resultBean);
                 Map<String,Object> result=new HashMap<String,Object>();
                 result.put("code",resultBean.getCode());
                 result.put("msg",resultBean.getMsg());
                response.getWriter().write(resultBean.toString());
            }else{
                Object obj=redisService.get(token);
                if(ObjectUtils.isEmpty(obj)){
                    //如果在redis里面查询不到数据/返回错误
                    resultBean=ResultUtils.error(EnumType.SYSTEMERROR);
                    logger.info("未通过过滤器,返回给前台数据:"+resultBean);
                    Map<String,Object> result=new HashMap<String,Object>();
                    result.put("code",resultBean.getCode());
                    result.put("msg",resultBean.getMsg());
                    response.getWriter().write(resultBean.toString());
                }else{
                    chain.doFilter(request, response);
                }
               
            }
            
        }
        
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        logger.info("过滤器初始化");
    }

    /**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isPass(String url) {
        if(url.contains("login"))
            return true;
        return false;
    }


}