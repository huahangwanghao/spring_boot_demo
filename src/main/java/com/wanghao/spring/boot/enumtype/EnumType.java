package com.wanghao.spring.boot.enumtype;

/**
 * Created by Administrator on 2017/4/26.
 * 
 * 创建一个类型,用于统一的处理
 * 
 */
public enum EnumType {
    SUCCECC(0,"成功"),
    SYSTEMERROR(-1,"系统错误"),
    AGEERROR(1,"年纪问题"),
    NOPERSON(2,"查无此人"),
    USEPWDERROR(3,"用户名/密码错误"),
    ;

    private Integer code;
    
    private String msg;

    EnumType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
