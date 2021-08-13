package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer age;
    private String name;
    private String address;
    private Date birthday;
    private List<String> hobby;
}
