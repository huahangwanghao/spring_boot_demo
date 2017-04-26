package com.wanghao.spring.boot.bean;/**
 * Created by Administrator on 2017/4/26.
 */

/**
 * 返回类
 *
 * @author WangH
 * @create 2017-04-26 11:09
 **/
public class ResultBean<T> {
    
    private Integer code;
    
    private String msg;
    
    private T data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
