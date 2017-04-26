package com.wanghao.spring.boot.exception;/**
 * Created by Administrator on 2017/4/26.
 */

/**
 * 自定义异常
 *
 * @author WangH
 * @create 2017-04-26 14:01
 **/
public class MyException extends  RuntimeException {
    
    private Integer code;
    public MyException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "code=" + code +
                '}';
    }
}
