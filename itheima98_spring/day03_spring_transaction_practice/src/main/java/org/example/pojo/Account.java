package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ssqswyf
 * @Date 2021/8/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String name;
    private Double money;

}
