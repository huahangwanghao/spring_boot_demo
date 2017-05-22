package com.wanghao.spring.boot.dao;

import com.wanghao.spring.boot.bean.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface OrderTableDao extends JpaRepository<OrderTable,Integer> {
    
    
    
    List<OrderTable> findByCrtDateBetween(Date start, Date end);
}
