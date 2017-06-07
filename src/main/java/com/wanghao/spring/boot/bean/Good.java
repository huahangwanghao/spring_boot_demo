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
public class Good {
    @Id
    @GeneratedValue
    private Integer goodId;
    
    private String goodName;

    private Integer goodAmount;
  
    private Date crtDate;
    
    private Integer version;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getGoodAmount() {
        return goodAmount;
    }

    public void setGoodAmount(Integer goodAmount) {
        this.goodAmount = goodAmount;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", goodAmount=" + goodAmount +
                ", crtDate=" + crtDate +
                ", version=" + version +
                '}';
    }
}
