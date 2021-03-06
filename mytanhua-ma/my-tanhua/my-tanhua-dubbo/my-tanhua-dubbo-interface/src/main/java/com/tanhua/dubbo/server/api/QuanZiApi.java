package com.tanhua.dubbo.server.api;

import com.tanhua.dubbo.server.pojo.Publish;
import com.tanhua.dubbo.server.vo.PageInfo;

/**
 * @Author ssqswyf
 * @Date 2021/8/20
 */
public interface QuanZiApi {

    /**
     * 发布动态
     *
     * @param publish
     * @return
     */
    boolean savePublish(Publish publish);


    /**
     * 查询好友动态
     *
     * @param userId
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<Publish> queryPublishList(Long userId, Integer page, Integer pageSize);
}
