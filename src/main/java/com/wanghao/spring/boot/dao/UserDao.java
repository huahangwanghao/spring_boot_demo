package com.wanghao.spring.boot.dao;

import com.wanghao.spring.boot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUserName(String s);
    

}
