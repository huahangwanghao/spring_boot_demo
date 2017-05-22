package com.wanghao.spring.boot.utils;/**
 * Created by Administrator on 2017/5/22.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化类
 *
 * @author WangH
 * @create 2017-05-22 14:16
 **/
public class DateUtils {

    public static Date string2Date(String date,String formate){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(formate);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
