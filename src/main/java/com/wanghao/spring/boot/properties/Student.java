package com.wanghao.spring.boot.properties;/**
 * Created by Administrator on 2017/4/25.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 创建一个学生类
 *
 * 需要注意俩点:
 *  1.需要添加俩个注解,第一个注解用于让controller/service找到对应的这个类
 *  2.第二个注解用于可以和配置文件进行关联起来
 *  3.然后提供get/set方法,让属性得到相应的值
 * 
 * 
 * @author WangH
 * @create 2017-04-25 14:54
 **/
@Component
@ConfigurationProperties(prefix = "student") //获取前缀是student
public class Student {

    private String name;
    private Integer age;


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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
