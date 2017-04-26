package com.wanghao.spring.boot.bean;/**
 * Created by Administrator on 2017/4/25.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * 员工的表
 *
 * @author WangH
 * @create 2017-04-25 15:27
 **/
@Entity
public class MyTable {
    
    
    @Id
    @GeneratedValue
    private Integer empId;
    private String name;
    //不满18岁不能入内
    @Min(value = 18,message = "未成年不能登录")
    private Integer age;


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
