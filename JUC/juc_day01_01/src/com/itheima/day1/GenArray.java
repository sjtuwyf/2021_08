package com.itheima.day1;

import java.util.Random;

//生成随机数组
public class GenArray {

    //数组长度
    public static final int ARRAY_LENGTH=400000000;

    public static int[] genArray(){

        Random random = new Random();
        int[] result = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            //随机数填充数组
            result[i]= random.nextInt(ARRAY_LENGTH*3);
        }
        return result;
    }
}