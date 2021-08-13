package com.itheima.day1;

//普通循环累加
public class SumNormal {

    public static void main(String[] args) {

        int count = 0;
        int[] src = GenArray.genArray();

        long start = System.currentTimeMillis();

        for (int i = 0; i < src.length; i++) {
            count+=src[i];
        }

        System.out.println("spend time: "+(System.currentTimeMillis()-start));
    }
}