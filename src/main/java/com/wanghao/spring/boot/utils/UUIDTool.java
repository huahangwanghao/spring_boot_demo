package com.wanghao.spring.boot.utils;
import java.util.UUID;

/**
 * 生成32位uuid的工具类.
 *
 * @author WangH
 * @create 2017-01-17 17:10
 **/
public class UUIDTool {

    /**
     * 自动生成32位的UUid
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
