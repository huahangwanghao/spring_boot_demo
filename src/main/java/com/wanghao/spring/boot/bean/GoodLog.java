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
public class GoodLog {
    @Id
    @GeneratedValue
    private Integer goodLogId;
  
    private Date crtDate;


    public Integer getGoodLogId() {
        return goodLogId;
    }

    public void setGoodLogId(Integer goodLogId) {
        this.goodLogId = goodLogId;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }
}
