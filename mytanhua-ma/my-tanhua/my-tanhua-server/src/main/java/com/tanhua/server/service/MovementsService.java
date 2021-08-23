package com.tanhua.server.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tanhua.dubbo.server.api.QuanZiApi;
import com.tanhua.dubbo.server.pojo.Publish;
import com.tanhua.dubbo.server.vo.PageInfo;
import com.tanhua.server.pojo.User;
import com.tanhua.server.pojo.UserInfo;
import com.tanhua.server.utils.RelativeDateFormat;
import com.tanhua.server.utils.UserThreadLocal;
import com.tanhua.server.vo.Movements;
import com.tanhua.server.vo.PageResult;
import com.tanhua.server.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/20
 */
@Service
public class MovementsService {

    @Reference(version = "1.0.0")
    private QuanZiApi quanZiApi;

    @Autowired
    private PicUploadService picUploadService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public Boolean saveMovements(String textContext,
                                 String location,
                                 String longitude,
                                 String latitude,
                                 MultipartFile[] multipartFile) {

        User user = UserThreadLocal.get();

        Publish publish = new Publish();
        publish.setUserId(user.getId());
        publish.setText(textContext);
        publish.setLocationName(location);
        publish.setLatitude(latitude);
        publish.setLongitude(longitude);

        ArrayList<String> imageUrls = new ArrayList<>();
        for (MultipartFile file : multipartFile) {
            PicUploadResult uploadResult = this.picUploadService.upload(file);
            imageUrls.add(uploadResult.getName());
        }
        publish.setMedias(imageUrls);

        return this.quanZiApi.savePublish(publish);

    }

    public PageResult queryPublishList(User user,Integer page,Integer pageSize) {
        PageResult pageResult = new PageResult();
        Long userId = null;
        if (user != null) {
            userId = user.getId();
        }
        PageInfo<Publish> pageInfo = this.quanZiApi.queryPublishList(userId, page, pageSize);

        user = UserThreadLocal.get();

        pageResult.setCounts(0);
        pageResult.setPages(0);
        pageResult.setPagesize(pageSize);
        pageResult.setPage(page);

        List<Publish> records = pageInfo.getRecords();

        if (CollectionUtils.isEmpty(records)) {
            return pageResult;
        }
        pageResult.setItems(this.fillValueToMovements(records));
        return pageResult;
    }

    private List<Movements> fillValueToMovements(List<Publish> records){
        User user = UserThreadLocal.get();
        List<Movements> movementsList = new ArrayList<>();
        List<Long> userIds = new ArrayList<>();
        for (Publish record : records) {
            Movements movements = new Movements();

            movements.setId(record.getId().toHexString());
            movements.setUserId(record.getUserId());

            if (!userIds.contains(record.getUserId())) {
                userIds.add(record.getUserId());
            }

            String likeUserCommentKey = "QUANZI_COMMENT_LIKE_USER_" + user.getId() + "_" + movements.getId();
            movements.setHasLiked(this.redisTemplate.hasKey(likeUserCommentKey) ? 1 : 0); //是否点赞

            String likeCommentKey = "QUANZI_COMMENT_LIKE_" + movements.getId();
            String value = this.redisTemplate.opsForValue().get(likeCommentKey);
            if(StringUtils.isNotEmpty(value)){
                movements.setLikeCount(Integer.valueOf(value)); //点赞数
            }else{
                movements.setLikeCount(0); //点赞数
            }

            String loveUserCommentKey = "QUANZI_COMMENT_LOVE_USER_" + user.getId() + "_" + movements.getId();
            movements.setHasLoved(this.redisTemplate.hasKey(loveUserCommentKey) ? 1 : 0); //是否喜欢

            String loveCommentKey = "QUANZI_COMMENT_LOVE_" + movements.getId();
            String loveValue = this.redisTemplate.opsForValue().get(loveCommentKey);
            if(StringUtils.isNotEmpty(loveValue)){
                movements.setLoveCount(Integer.valueOf(loveValue)); //喜欢数
            }else{
                movements.setLoveCount(0); //喜欢数
            }

            movements.setDistance("1.2公里"); //TODO 距离
            movements.setCommentCount(30); //TODO 评论数
            movements.setCreateDate(RelativeDateFormat.format(new Date(record.getCreated()))); //发布时间，10分钟前
            movements.setTextContent(record.getText());
            movements.setImageContent(record.getMedias().toArray(new String[]{}));

            movementsList.add(movements);
        }


        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.in("user_id", userIds);
        List<UserInfo> userInfoList = this.userInfoService.queryUserInfoList(userInfoQueryWrapper);

        for (Movements movements : movementsList) {
            for (UserInfo userInfo : userInfoList) {
                if (movements.getUserId().longValue() == userInfo.getUserId().longValue()) {

                    movements.setTags(StringUtils.split(userInfo.getTags(), ','));
                    movements.setNickname(userInfo.getNickName());
                    movements.setGender(userInfo.getSex().name().toLowerCase());
                    movements.setAvatar(userInfo.getLogo());
                    movements.setAge(userInfo.getAge());

                    break;
                }
            }
        }

        return movementsList;
    }


    public PageResult queryUserPublishList(Integer page, Integer pageSize) {
        return this.queryPublishList(UserThreadLocal.get(), page, pageSize);
    }
}
