package com.wanghao.spring.boot.service;

import com.wanghao.spring.boot.bean.OneLevel;
import com.wanghao.spring.boot.bean.OrderTable;
import com.wanghao.spring.boot.bean.PageInfo;
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

    ResultBean getGoodsByMonth(String month);

    /**
     * 通过查询条件,查询客户购买的情况
     * @param pageInfo
     * @return
     */
    ResultBean getOrderBySearch(PageInfo pageInfo);
    
    
    ResultBean updateGoods();
    
    
}
