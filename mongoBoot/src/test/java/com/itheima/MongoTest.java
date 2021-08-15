package com.itheima;

import com.itheima.pojo.Comment;
import com.itheima.service.CommentService;
import com.itheima.utils.IdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoTest {

    @Autowired
    private CommentService commentService;
    @Autowired
    private IdWorker idWorker;

    @Test
    public void testAddDoc() {
        Comment comment = new Comment();
        String id = idWorker.nextId() + "";
        comment.set_id(id);
        //初始化数据
        comment.setPublishdate(new Date());
        comment.setThumbup(0);
        commentService.addDoc(comment);
    }
}
