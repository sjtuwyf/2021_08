package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author ssqswyf
 * @Date 2021/8/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int uid;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
}
