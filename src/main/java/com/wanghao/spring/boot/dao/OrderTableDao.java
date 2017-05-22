package com.wanghao.spring.boot.dao;

import com.wanghao.spring.boot.bean.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface OrderTableDao extends JpaRepository<OrderTable,Integer> ,JpaSpecificationExecutor<OrderTable> {
    
    
    
    List<OrderTable> findByCrtDateBetween(Date start, Date end);

    @Query(nativeQuery = true,value = "\n" +
            "\n" +
            "select DATE_FORMAT(o.crt_date,'%Y-%m-%d') as crtDate,sum(o.amount) as amount from order_table o where  DATE_FORMAT(o.crt_date,'%Y-%m')=?1 GROUP BY DATE_FORMAT(o.crt_date,'%Y-%m-%d')\n" +
            "\n")
    List<Map<String,Object>>  getSumMoney(String month);

    @Query(nativeQuery = true,value = "select '1' as a  ")
    List<Map<String,Object>>  getSumMoney1();
}
