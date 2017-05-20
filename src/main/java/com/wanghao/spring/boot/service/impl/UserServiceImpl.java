package com.wanghao.spring.boot.service.impl;/**
 * Created by Administrator on 2017/5/19.
 */

import com.wanghao.spring.boot.bean.OneLevel;
import com.wanghao.spring.boot.bean.OrderTable;
import com.wanghao.spring.boot.bean.ResultBean;
import com.wanghao.spring.boot.dao.OneLevelDao;
import com.wanghao.spring.boot.dao.OrderTableDao;
import com.wanghao.spring.boot.service.UserService;
import com.wanghao.spring.boot.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户的实现类
 *
 * @author WangH
 * @create 2017-05-19 18:28
 **/
@Service
public class UserServiceImpl implements UserService {
    protected static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private OneLevelDao oneLevelDao;
    @Autowired
    private OrderTableDao orderTableDao;

    @Override
    public ResultBean addOneLevel(OneLevel oneLevel) {
        oneLevel.setCrtDate(new Date());
        oneLevelDao.save(oneLevel);
        return ResultUtils.success("新增成功");
    }

    @Override
    public ResultBean getAllOneLevel() {
        
        return ResultUtils.success(oneLevelDao.findAll());
    }

    @Override
    public ResultBean updateOneLevelNameById(OneLevel oneLevel) {
        oneLevel.setCrtDate(new Date());
        oneLevelDao.saveAndFlush(oneLevel);
        return  ResultUtils.success("修改成功");
    }

    @Override
    public ResultBean addOrder(OrderTable orderTable) {
        orderTable.setCrtDate(new Date());
        orderTableDao.save(orderTable);
        return ResultUtils.success(0);
    }


}
