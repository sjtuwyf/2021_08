package org.example;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author ssqswyf
 * @Date 2021/8/14
 */
public class MangoTest {

    private MongoClient client;
    private MongoCollection<Document> comment;
    @Before
    public void init() {
        //创建连接
        client =new MongoClient("192.168.211.138");
        //打开数据库
        MongoDatabase commentdb = client.getDatabase("commentdb");
        //获取集合
        comment = commentdb.getCollection("comment");
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void findById(){

        FindIterable<Document> documents = comment.find(new BasicDBObject("_id", "1"));
        for (Document document : documents) {
            System.out.println("_id：" + document.get("_id"));
            System.out.println("内容：" + document.get("content"));
            System.out.println("用户ID:" + document.get("userid"));
            System.out.println("点赞数：" + document.get("thumbup"));
        }
    }
}
