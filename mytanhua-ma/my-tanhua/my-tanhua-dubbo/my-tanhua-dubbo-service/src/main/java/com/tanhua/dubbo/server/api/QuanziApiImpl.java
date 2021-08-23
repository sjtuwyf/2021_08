package com.tanhua.dubbo.server.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tanhua.dubbo.server.pojo.Album;
import com.tanhua.dubbo.server.pojo.Publish;
import com.tanhua.dubbo.server.pojo.TimeLine;
import com.tanhua.dubbo.server.pojo.Users;
import com.tanhua.dubbo.server.vo.PageInfo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/20
 */
@Service(version = "1.0.0")
public class QuanziApiImpl implements QuanZiApi {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean savePublish(Publish publish) {

        if (publish.getUserId() == null) {
            return false;
        }

        try {

            publish.setId(ObjectId.get());
            publish.setCreated(System.currentTimeMillis());
            publish.setSeeType(1);

            this.mongoTemplate.save(publish);

            Album album = new Album();
            album.setId(ObjectId.get());
            album.setPublishId(publish.getId());
            album.setCreated(System.currentTimeMillis());

            this.mongoTemplate.save(album,"quanzi_album_"+publish.getUserId());


            Query query = Query.query(Criteria.where("userId").is(publish.getUserId()));
            List<Users> users = this.mongoTemplate.find(query, Users.class);
            for (Users user : users) {
                TimeLine timeLine = new TimeLine();
                timeLine.setId(ObjectId.get());
                timeLine.setUserId(publish.getUserId());
                timeLine.setPublishId(publish.getId());
                timeLine.setDate(System.currentTimeMillis());

                this.mongoTemplate.save(timeLine,"quanzi_time_line_"+user.getFriendId());

            }
            return true;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public PageInfo<Publish> queryPublishList(Long userId, Integer page, Integer pageSize) {

        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by(Sort.Order.desc("date")));
        Query query = new Query().with(pageable);
        String tableName = "quanzi_time_line";
        if (null==userId) {
            tableName += "recommend";
        } else {
            tableName += userId;
        }

        List<TimeLine> timeLines = this.mongoTemplate.find(query, TimeLine.class, tableName);
        List<ObjectId> ids = new ArrayList<>();
        for (TimeLine timeLine : timeLines) {
            ids.add(timeLine.getPublishId());
        }
        Object o;
        Query queryPublish = Query.query(Criteria.where("id").is(ids)).with(Sort.by(Sort.Order.desc("created")));

        List<Publish> publishList = this.mongoTemplate.find(queryPublish, Publish.class);

        PageInfo<Publish> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(page);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(0);
        pageInfo.setRecords(publishList);


        return pageInfo;
    }
}


























