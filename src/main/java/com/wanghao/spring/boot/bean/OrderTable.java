package com.wanghao.spring.boot.bean;/**
 * Created by Administrator on 2017/5/19.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 以及品类
 *
 * @author WangH
 * @create 2017-05-19 17:22
 **/
@Entity
public class OrderTable {
    @Id
    @GeneratedValue
    private Integer orderId;
    
    private String goodName;

    private Integer oneLevelId;

    private String cName;

    private String  cPhone;

    private BigDecimal amount;

    private Integer goodCount;

    private Date crtDate;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getOneLevelId() {
        return oneLevelId;
    }

    public void setOneLevelId(Integer oneLevelId) {
        this.oneLevelId = oneLevelId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    @Override
    public String toString() {
        return "OrderTable{" +
                "orderId=" + orderId +
                ", goodName='" + goodName + '\'' +
                ", oneLevelId=" + oneLevelId +
                ", cName='" + cName + '\'' +
                ", cPhone='" + cPhone + '\'' +
                ", amount=" + amount +
                ", goodCount=" + goodCount +
                ", crtDate=" + crtDate +
                '}';
    }
}
