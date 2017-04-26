package com.wanghao.spring.boot.exception;/**
 * Created by Administrator on 2017/4/26.
 */

import com.wanghao.spring.boot.bean.ResultBean;
import com.wanghao.spring.boot.enumtype.EnumType;
import com.wanghao.spring.boot.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制层的异常处理类,
 * ControllerAdvice
 * 这个类中对于所有controller中的异常都可以进行拦截,然后进行处理
 *
 * @author WangH
 * @create 2017-04-26 14:41
 **/
@ControllerAdvice
public class ExceptionHandler {
    
    protected  static Logger logger= LoggerFactory.getLogger(ExceptionHandler.class);
    
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBean handler(Exception e){
        logger.error("异常:{}",e);
        
        if(e instanceof  MyException){
            MyException myException= (MyException) e;
            ResultBean resultBean=new ResultBean();
            resultBean.setCode(((MyException) e).getCode());
            resultBean.setMsg(e.getMessage());
            return resultBean;
        }
        
        return ResultUtils.error(EnumType.SYSTEMERROR);
        
    }
    
}
