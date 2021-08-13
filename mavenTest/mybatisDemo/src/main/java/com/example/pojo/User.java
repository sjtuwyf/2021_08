package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int uid;
    private String username;
    private String sex;
    private Date birthday;
    private String address;

    private List<Account> accountList;
    private List<Role> roleList;
}
