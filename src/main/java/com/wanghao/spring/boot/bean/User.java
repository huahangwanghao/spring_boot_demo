package com.wanghao.spring.boot.bean;/**
 * Created by Administrator on 2017/5/19.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户表
 *
 * @author WangH
 * @create 2017-05-19 17:22
 **/
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer oneId;
    
    private String userName;

    private String pwd;

    private Date crtDate;

    public Integer getOneId() {
        return oneId;
    }

    public void setOneId(Integer oneId) {
        this.oneId = oneId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "oneId=" + oneId +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", crtDate=" + crtDate +
                '}';
    }
}
