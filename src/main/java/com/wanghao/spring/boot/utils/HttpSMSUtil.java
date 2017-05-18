package com.wanghao.spring.boot.utils;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wanghao on 2017/5/6.
 */
public class HttpSMSUtil {

    public static void main(String[] args) {
        HttpPost post = null;
        String url="http://utf8.sms.webchinese.cn/";
        String appid="";
        try{
        HttpClient httpClient=new DefaultHttpClient();
        // 设置超时时间
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
        Map<String,Object> map=new HashMap<String,Object>();
        post = new HttpPost(url);
        // 构造消息头
        post.setHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
        post.setHeader("Connection", "Close");
        String sessionId = getSessionId();
        post.setHeader("SessionId", sessionId);
        post.setHeader("appid", appid);
        map.put("smsMob","18146550645");
        map.put("smsText","nihao");
        map.put("Key","d1a25fb0a6b0e2c0e628");
        map.put("Uid", "huahangwanghao");
        // 构建消息实体
        StringEntity entity = new StringEntity(map.toString(), Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        post.setEntity(entity);

        HttpResponse response = httpClient.execute(post);

        // 检验返回码
        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode != HttpStatus.SC_OK){
            System.out.println("ok");
        }else{
            int retCode = 0;
            String sessendId = "";
            // 返回码中包含retCode及会话Id
            for(Header header : response.getAllHeaders()){
                if(header.getName().equals("retcode")){
                    retCode = Integer.parseInt(header.getValue());
                }
                if(header.getName().equals("SessionId")){
                    sessendId = header.getValue();
                }
            }


        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        if(post != null){
            try {
                post.releaseConnection();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }
    public static String getSessionId(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
    }

}
