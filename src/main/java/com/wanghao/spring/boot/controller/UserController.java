package com.wanghao.spring.boot.controller;/**
 * Created by Administrator on 2017/4/25.
 */

import com.wanghao.spring.boot.bean.OneLevel;
import com.wanghao.spring.boot.bean.OrderTable;
import com.wanghao.spring.boot.bean.PageInfo;
import com.wanghao.spring.boot.bean.ResultBean;
import com.wanghao.spring.boot.bean.User;
import com.wanghao.spring.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 *
 * @author WangH
 * @create 2017-04-25 11:37
 **/
@RestController
public class UserController {
    
    protected static Logger logger= LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userServicel;
    
   
    @GetMapping(value = "/addOneLevel")
    public ResultBean sayHello(OneLevel oneLevel){
        logger.info("-------------------->{}",oneLevel);
        return userServicel.addOneLevel(oneLevel);
    }

    @GetMapping(value = "/getAllOneLevel")
    public ResultBean getAllOneLevel(){
        return userServicel.getAllOneLevel();
    }

    @GetMapping(value = "/updateOneLevelNameById")
    public ResultBean updateOneLevelNameById(OneLevel oneLevel){
        return userServicel.updateOneLevelNameById(oneLevel);
    }
    @PostMapping(value = "/addOrder")
    public ResultBean addOrder(OrderTable orderTable){
        logger.info("-------------------->{}",orderTable);
        return userServicel.addOrder(orderTable);
    }

    @PostMapping(value = "/login")
    public ResultBean login(User user){
        logger.info("-------------------->{}",user);
        return userServicel.login(user);
    }
    @PostMapping(value = "/getMoneyByMonth")
    public ResultBean getMoneyByMonth(@RequestParam("month")String month){
        logger.info("-------------------->{}",month);
        return userServicel.getMoneyByMonth(month);
    }
    @PostMapping(value = "/getGoodsByMonth")
    public ResultBean getGoodsByMonth(@RequestParam("month")String month){
        logger.info("-------------------->{}",month);
        return userServicel.getGoodsByMonth(month);
    }
    @GetMapping(value = "/getOrderBySearch")
    public ResultBean getOrderBySearch(PageInfo pageInfo){
        logger.info("-------------------->{}");
        return userServicel.getOrderBySearch(pageInfo);
    }
    @GetMapping(value = "/updateVerson")
    public ResultBean updateVerson(){
        logger.info("-------------------->{}");
        return userServicel.updateGoods();
    }
    
}
