package org.example;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Author ssqswyf
 * @Date 2021/8/15
 */
public class zookeeperTest {
    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3,10);
//创建客户端
/**
 * 参数1：连接的ip地址和端口号
 * 参数2：会话超时时间，单位毫秒
 * 参数3：连接超时时间，单位毫秒
 * 参数4：失败重试策略
 */
        CuratorFramework client =  CuratorFrameworkFactory.newClient("192.168.211.128:2181",3000,1000,retryPolicy);
//开启客户端(会阻塞到会话连接成功为止)
        client.start();
        client.create().forPath("/a");
        client.create().forPath("/b", "这是b节点的内容".getBytes());
        client.close();


    }
}
