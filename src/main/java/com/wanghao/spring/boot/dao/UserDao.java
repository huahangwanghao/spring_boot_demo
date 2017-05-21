package com.wanghao.spring.boot.dao;

import com.wanghao.spring.boot.bean.OneLevel;
import com.wanghao.spring.boot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface UserDao extends JpaRepository<User,Integer> {
    User findOneByuseName(String s);
}
