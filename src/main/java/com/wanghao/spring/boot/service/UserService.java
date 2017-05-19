package com.wanghao.spring.boot.service;

import com.wanghao.spring.boot.bean.OneLevel;
import com.wanghao.spring.boot.bean.ResultBean;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface UserService {
    
    
    ResultBean addOneLevel(OneLevel oneLevel);
    
    
}
