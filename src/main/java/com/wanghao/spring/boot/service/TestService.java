package com.wanghao.spring.boot.service;

import com.wanghao.spring.boot.bean.MyTable;
import com.wanghao.spring.boot.bean.ResultBean;

/**
 * Created by Administrator on 2017/4/26.
 */
public interface TestService {

    ResultBean findAll();

    ResultBean insertData(MyTable myTable);

    ResultBean deleteOneById(Integer id);
}
