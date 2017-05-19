package com.wanghao.spring.boot.bean;/**
 * Created by Administrator on 2017/5/19.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 以及品类
 *
 * @author WangH
 * @create 2017-05-19 17:22
 **/
@Entity
public class OneLevel {
    @Id
    @GeneratedValue
    private Integer oneId;
    
    private String name;
    
    private Date crtDate;

    public Integer getOneId() {
        return oneId;
    }

    public void setOneId(Integer oneId) {
        this.oneId = oneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    @Override
    public String toString() {
        return "OneLevel{" +
                "oneId=" + oneId +
                ", name='" + name + '\'' +
                '}';
    }
}
