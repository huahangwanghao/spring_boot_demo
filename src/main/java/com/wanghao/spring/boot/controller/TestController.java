package com.wanghao.spring.boot.controller;/**
 * Created by Administrator on 2017/4/25.
 */

import com.wanghao.spring.boot.bean.MyTable;
import com.wanghao.spring.boot.bean.ResultBean;
import com.wanghao.spring.boot.properties.Student;
import com.wanghao.spring.boot.dao.MyTableDao;
import com.wanghao.spring.boot.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 控制器
 *
 * @author WangH
 * @create 2017-04-25 11:37
 **/
@RestController
public class TestController {
    
    protected static Logger logger= LoggerFactory.getLogger(TestController.class);
   
    @Value("${content1}")
    private String content;
    
   
    @Autowired
    private Student student;
    
    
    @GetMapping(value = "/hello")
    public String sayHello(){
        return student.toString();
    }



    @PostMapping(value = "/hello")
    public String b(){
        return content;
    }

    
   //-------------------------------分割线---------------------------------- 
    
    
    @Autowired
    private MyTableDao myTableDao;

    /**
     * 这里可以进行自动注入的方式就可以啦
     * @Valid 表示对于后面的对象进行验证
     * bindingResult 用于接受验证后的结果
     * @param myTable
     */
    @PostMapping("/insert")
    public ResultBean insert(@Valid  MyTable myTable, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //如果有错误信息,进行把信息打印
            String errorMsg=bindingResult.getFieldError().getDefaultMessage();
            logger.error("验证信息错误 {}",errorMsg);
            return ResultUtils.error(1,errorMsg);
        }
        myTable.setName(myTable.getName());
        myTable.setAge(myTable.getAge());
         MyTable myTable1=myTableDao.save(myTable);
        return ResultUtils.success(myTable1);
    }


    @PostMapping("/insert2")
    public String insert2(@RequestBody MyTable myTable){
        myTable=myTableDao.save(myTable);
        if(null!=myTable){
            return "ok";
        }else {
            return "fail";
        }
    }



    @PostMapping("updateById")
    public String updateById(@RequestParam("id") Integer id){
        //myTableDao.
        MyTable myTable=new MyTable();
        myTable.setEmpId(id);
        myTable.setName("fuck");
        myTable.setAge(123);
         myTableDao.save(myTable);
         return "ok";
    }


    /**
     * 得到所有对象
     * @return
     */
    @GetMapping("getAll")
    public List<MyTable> getAll(){
        return myTableDao.findAll();
    }

    /**
     * 得到一个对象
     * @param id
     * @return
     */
    @GetMapping("getOneById")
    public MyTable getOneByIdgetOneById(@RequestParam("id") Integer id){
        return myTableDao.findOne(id);
    }


    /**
     * 删除一个对象
     * @param id
     * @return
     */
    @GetMapping("deleteOneById")
    public void deleteOneById(@RequestParam("id") Integer id){
         myTableDao.delete(id);
    }

    /**
     * 删除所有对象
     * @return
     */
    @GetMapping("deleteAll")
    public void deleteAll(){
        myTableDao.deleteAll();
    }







}
