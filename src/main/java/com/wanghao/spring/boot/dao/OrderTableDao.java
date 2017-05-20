package com.wanghao.spring.boot.dao;

import com.wanghao.spring.boot.bean.OneLevel;
import com.wanghao.spring.boot.bean.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface OrderTableDao extends JpaRepository<OrderTable,Integer> {
}
