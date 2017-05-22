package com.wanghao.spring.boot.service;

import com.wanghao.spring.boot.bean.OneLevel;
import com.wanghao.spring.boot.bean.OrderTable;
import com.wanghao.spring.boot.bean.ResultBean;
import com.wanghao.spring.boot.bean.User;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface UserService {
    
    
    ResultBean addOneLevel(OneLevel oneLevel);


    ResultBean getAllOneLevel();

    ResultBean updateOneLevelNameById(OneLevel oneLevel);

    ResultBean addOrder(OrderTable orderTable);

    ResultBean login(User user);

    ResultBean getMoneyByMonth(String month);
}
