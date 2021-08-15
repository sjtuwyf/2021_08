package com.itheima.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private int current;

    private List<T> data;

    private int pages;
}
