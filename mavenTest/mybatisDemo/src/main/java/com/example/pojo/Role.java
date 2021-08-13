package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer rid;
    private String rName;
    private String rDesc;
}
