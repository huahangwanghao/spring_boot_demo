package com.wanghao.spring.boot.dao;

import com.wanghao.spring.boot.bean.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface GoodDao extends JpaRepository<Good,Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value = "update good set good_amount=?1 , version=?2  where  version=?3")
    int updateByVersion(Integer amount,Integer newVersion,Integer oldVersion);

}
