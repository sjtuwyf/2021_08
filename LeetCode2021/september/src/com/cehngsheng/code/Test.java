package com.cehngsheng.code;

import sun.security.util.ArrayUtil;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * @author ssqswyf
 * @date 2021/9/15
 */
public class Test {
    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MONTH, -1);
//        String time = sdf.format(calendar.getTime());
//        System.out.println(time);

//        Integer[] t = new Integer[]{0,4,76,3,3};
//        Arrays.sort(t);
//        System.out.println(Arrays.toString(t));
//
//        Arrays.parallelSort(t);
//        System.out.println(Arrays.toString(t));
//
//        Arrays.sort(t, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1 ;
//            }
//        });
//        System.out.println(Arrays.toString(t));
//        Arrays.asList(t).sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });
//        int[][] s = new int[5][2];
//        s[0] = new int[]{1,2};
//        s[1] = new int[]{2,5};
//        s[2] = new int[]{3,4};
//        s[3] = new int[]{4,6};
//        s[4] = new int[]{5,1};
//        Arrays.sort(s, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//
//                return o1[1]-o2[1];
//            }
//        });
//
//        for (int i = 0; i < s.length; i++) {
//            for (int i1 = 0; i1 < s[i].length; i1++) {
//                System.out.println(s[i][i1]);
//            }
//        }
////        Arrays.sort(t, );
        new Test().calenderTest();
    }

    public void calenderTest(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        calendar.set(0, 0, 1, 0, 0, 0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(calendar.getTime());
        System.out.println(format);
    }
}
