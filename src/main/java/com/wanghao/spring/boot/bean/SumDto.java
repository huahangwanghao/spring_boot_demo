package com.wanghao.spring.boot.bean;/**
 * Created by Administrator on 2017/5/22.
 */

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author WangH
 * @create 2017-05-22 15:21
 **/
public class SumDto {
    
    private Date crtDate;
    private BigDecimal amount;

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SumDto{" +
                "crtDate=" + crtDate +
                ", amount=" + amount +
                '}';
    }
}
