package com.wanghao.spring.boot.zookeeper;/**
 * Created by Administrator on 2019/2/26.
 */

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * 测试
 *
 * @author WangH
 * @create 2019-02-26 15:33
 **/
public class Client {
    
    static String connectionOfOne = "127.0.0.1:2181";
    static String connectionOfMuilt = "127.0.0.1:2181,127.0.0.1:2182";
    
    /**
     * 如果  是单机  
     * @param args
     * @throws IOException
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper(connectionOfOne, 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                
            }
        });
        
        //create(zk);
        
       // update(zk);
        
        // delete(zk);
        
        get(zk);
        
    }
    
    public static void update(ZooKeeper zk) throws KeeperException, InterruptedException {
        Stat status = zk.setData("/good","good1".getBytes(),0);
        status.getVersion();
    }
    
    public static  void create(ZooKeeper zk) throws KeeperException, InterruptedException, IOException {
        //zk.create("/good","good".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        List<String> list = zk.getChildren("/",null);
        Thread.sleep(4000);
        System.out.println(zk.getState());
        System.out.println(list);

        //这个可以用于 session重新获取...
        long sessionId = zk.getSessionId();
        byte[] sessionPasswd = zk.getSessionPasswd();
        zk = new ZooKeeper("",123,null,sessionId,sessionPasswd);

        zk.create("/yibu", "yibu".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new AsyncCallback.StringCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, String name) {
                System.out.println(ctx);
            }
        },"this is test");

        Thread.sleep(2000);

        System.out.println("创建成功");
    }
    
    public static  void delete(ZooKeeper zk) throws KeeperException, InterruptedException {
        zk.delete("/good",1);
    }
    
    public static  void get(ZooKeeper zk) throws KeeperException, InterruptedException {
        List<String> list = zk.getChildren("/good",true);
        for(String s:list){
            System.out.println(s);
        }
    }
    
}
