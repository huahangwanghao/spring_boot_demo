package com.wanghao.spring.boot.service.impl;/**
 * Created by Administrator on 2017/4/26.
 */

import com.wanghao.spring.boot.bean.MyTable;
import com.wanghao.spring.boot.bean.ResultBean;
import com.wanghao.spring.boot.dao.MyTableDao;
import com.wanghao.spring.boot.enumtype.EnumType;
import com.wanghao.spring.boot.service.TestService;
import com.wanghao.spring.boot.utils.ResultUtils;
import org.apache.commons.lang.enums.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的实现
 *
 * @author WangH
 * @create 2017-04-26 11:15
 **/
@Service
public class TestServiceImpl implements TestService {
    static Map<String,Object> map=new HashMap<String,Object>();
    @Autowired
    private MyTableDao myTableDao;

    /**
     * 得到所有的信息
     */
    @Override
    public ResultBean findAll() {
        ResultBean resultBean=new ResultBean();
        long time=System.currentTimeMillis();
        Object old=map.get("time");
        if(old==null){
            List<MyTable> list= myTableDao.findAll();
            resultBean.setCode(0);
            resultBean.setMsg("成功");
            resultBean.setData(list);
            map.put("time",time);
        }else{
            long oldTime=Long.valueOf(map.get("time").toString());
            if(System.currentTimeMillis()-oldTime<1){
                return ResultUtils.error(EnumType.SYSTEMERROR);
            }else{
                List<MyTable> list= myTableDao.findAll();
                resultBean.setCode(0);
                resultBean.setMsg("成功");
                resultBean.setData(list);
                map.put("time",time);
            }
        }




        return resultBean;
    }

    @Override
    public ResultBean insertData(MyTable myTable) {
        myTable= myTableDao.save(myTable);
        return ResultUtils.success(myTable);
    }

    @Override
    public ResultBean deleteOneById(Integer id) {
        myTableDao.delete(id);
        return ResultUtils.success(0);
    }
}
