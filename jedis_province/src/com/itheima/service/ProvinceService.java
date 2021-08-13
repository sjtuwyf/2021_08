package com.itheima.service;

import com.alibaba.fastjson.JSON;
import com.itheima.dao.ProvinceDao;
import com.itheima.pojo.Province;
import com.itheima.utils.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 包名:com.itheima.service
 *
 * @author Leevi
 * 日期2020-07-26  15:10
 */
public class ProvinceService {
    private ProvinceDao provinceDao = new ProvinceDao();
    public List<Province> findAll() throws Exception {
        //1. 从redis服务器中获取所有省份信息
        Jedis jedis = JedisUtil.getJedis();
        String province_list = jedis.get("province_list");
        //2. 判断province_list是否为null
        if (province_list == null) {
            //说明，redis中还没有缓存
            //调用dao层的方法，到mysql数据库中查询出所有省份信息
            List<Province> provinceList = provinceDao.findAll();
            //将provinceList转换成json字符串，然后存储到redis服务器中
            province_list = JSON.toJSONString(provinceList);
            jedis.set("province_list",province_list);
        }

        //归还连接
        jedis.close();

        //我们要返回给Servlet的是List<Province>,所以要将province_list转换成List<Province>
        return JSON.parseArray(province_list, Province.class);
    }
}
