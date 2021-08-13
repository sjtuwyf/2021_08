package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer aid;
    private Double money;
    private Integer uid;

    private User user;
}
