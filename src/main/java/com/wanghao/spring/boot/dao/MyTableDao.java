package com.wanghao.spring.boot.dao;

import com.wanghao.spring.boot.bean.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/4/25.
 */
public interface MyTableDao extends JpaRepository<MyTable,Integer> {
}
