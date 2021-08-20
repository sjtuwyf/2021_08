package com.tanhua.sso.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.spi.ior.ObjectKey;
import com.tanhua.sso.mapper.UserMapper;
import com.tanhua.sso.pojo.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Value("${jwt.secret}")
    private String secret;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private HuanXinService huanXinService;

    /**
     * 登录逻辑
     *
     * @param mobile
     * @param code
     * @return 如果校验成功返回token，失败返回null
     */
    public String login(String mobile, String code) {
        //校验验证码是否正确
        String redisKey = "CHECK_CODE_" + mobile;
        String value = this.redisTemplate.opsForValue().get(redisKey);
        if (StringUtils.isEmpty(value)) {
            //验证码失效
            return null;
        }

        if (!StringUtils.equals(value, code)) {
            // 验证码输入错误
            return null;
        }

        Boolean isNew = false; //默认是已注册

        //校验该手机号是否已经注册，如果没有注册，需要注册一个账号，如果已经注册，直接登录
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        User user = this.userMapper.selectOne(queryWrapper);
        if (null == user) {
            // 该手机号未注册
            user = new User();
            user.setMobile(mobile);
            // 默认密码
            user.setPassword(DigestUtils.md5Hex("123456"));
            this.userMapper.insert(user);

            isNew = true;

            //注册用户到环信平台
            this.huanXinService.register(user.getId());
        }

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("mobile", mobile);
        claims.put("id", user.getId());

        // 生成token
        String token = Jwts.builder()
                .setClaims(claims) //设置响应数据体
                .signWith(SignatureAlgorithm.HS256, secret) //设置加密方法和加密盐
                .compact();

        try {
            // 将token存储到redis中
            String redisTokenKey = "TOKEN_" + token;
            String redisTokenValue = MAPPER.writeValueAsString(user);
            this.redisTemplate.opsForValue().set(redisTokenKey, redisTokenValue, Duration.ofHours(1));
        } catch (Exception e) {
            LOGGER.error("存储token出错", e);
            return null;
        }

        try {
            //发送消息
            Map<String, Object> msg = new HashMap<>();
            msg.put("id", user.getId());
            msg.put("mobile", mobile);
            msg.put("date", new Date());
            this.rocketMQTemplate.convertAndSend("tanhua-sso-login", msg);
        } catch (Exception e) {
            LOGGER.error("发送消息出错", e);
        }

        return isNew + "|" + token;
    }

    public User queryUserByToken(String token) {
        try {
            String redisTokenKey = "TOKEN_" + token;
            String cacheData = this.redisTemplate.opsForValue().get(redisTokenKey);
            if (StringUtils.isEmpty(cacheData)) {
                return null;
            }
            // 刷新时间
            this.redisTemplate.expire(redisTokenKey, 1, TimeUnit.HOURS);
            return MAPPER.readValue(cacheData, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
