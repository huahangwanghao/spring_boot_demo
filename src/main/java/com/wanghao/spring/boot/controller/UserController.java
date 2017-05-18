package com.wanghao.spring.boot.controller;/**
 * Created by Administrator on 2017/4/25.
 */

import com.wanghao.spring.boot.bean.MyTable;
import com.wanghao.spring.boot.bean.ResultBean;
import com.wanghao.spring.boot.dao.MyTableDao;
import com.wanghao.spring.boot.enumtype.EnumType;
import com.wanghao.spring.boot.exception.MyException;
import com.wanghao.spring.boot.properties.Student;
import com.wanghao.spring.boot.service.TestService;
import com.wanghao.spring.boot.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 控制器
 *
 * @author WangH
 * @create 2017-04-25 11:37
 **/
@RestController
public class UserController {
    
    protected static Logger logger= LoggerFactory.getLogger(UserController.class);
   

}
