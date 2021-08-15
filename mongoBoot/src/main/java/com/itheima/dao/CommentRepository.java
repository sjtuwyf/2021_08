package com.itheima.dao;

import com.itheima.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
}
