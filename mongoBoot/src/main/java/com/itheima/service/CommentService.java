package com.itheima.service;

import com.itheima.dao.CommentRepository;
import com.itheima.pojo.Comment;
import com.itheima.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IdWorker idWorker;

    public void add(Comment comment) {
        String id = idWorker.nextId() + "";
        comment.set_id(id);
        //初始化数据
        comment.setPublishdate(new Date());
        comment.setThumbup(0);
        commentRepository.save(comment);
    }

    public void addDoc(Comment comment){
        commentRepository.insert(comment);
    }
}
