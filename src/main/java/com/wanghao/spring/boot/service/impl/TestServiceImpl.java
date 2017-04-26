package com.wanghao.spring.boot.service.impl;/**
 * Created by Administrator on 2017/4/26.
 */

import com.wanghao.spring.boot.bean.MyTable;
import com.wanghao.spring.boot.bean.ResultBean;
import com.wanghao.spring.boot.dao.MyTableDao;
import com.wanghao.spring.boot.service.TestService;
import com.wanghao.spring.boot.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类的实现
 *
 * @author WangH
 * @create 2017-04-26 11:15
 **/
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private MyTableDao myTableDao;

    /**
     * 得到所有的信息
     */
    @Override
    public ResultBean findAll() {
        List<MyTable> list= myTableDao.findAll();
        ResultBean resultBean=new ResultBean();
        resultBean.setCode(0);
        resultBean.setMsg("成功");
        resultBean.setData(list);
        return resultBean;
    }

    @Override
    public ResultBean insertData(MyTable myTable) {
        myTable= myTableDao.save(myTable);
        return ResultUtils.success(myTable);
    }
}
