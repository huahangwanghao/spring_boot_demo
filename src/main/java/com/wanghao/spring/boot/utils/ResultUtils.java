package com.wanghao.spring.boot.utils;/**
 * Created by Administrator on 2017/4/26.
 */

import com.wanghao.spring.boot.bean.ResultBean;

/**
 * 返回类的工具类
 *
 * @author WangH
 * @create 2017-04-26 11:08
 **/
public class ResultUtils<T> {

    /**
     * 成功的返回类
     * @return
     */
    public static ResultBean success (){
        ResultBean resultBean=new ResultBean();
        resultBean.setCode(0);
        resultBean.setMsg("成功");
        return resultBean;
    }



    /**
     * 成功的返回类
     * @return
     */
    public static ResultBean success (Object object){
        ResultBean resultBean=new ResultBean();
        resultBean.setCode(0);
        resultBean.setMsg("成功");
        resultBean.setData(object);
        return resultBean;
    }
    
    /**
     * 返回错误提示
     * @param code
     * @param msg
     * @return
     */
    public static ResultBean error(Integer code,String msg){
        ResultBean resultBean=new ResultBean();
        resultBean.setCode(code);
        resultBean.setMsg(msg);
        return resultBean;
    }
    
    
    
}
