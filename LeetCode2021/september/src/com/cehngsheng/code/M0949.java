package com.cehngsheng.code;

import com.sun.xml.internal.ws.util.StringUtils;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ssqswyf
 * @date 2021/9/30
 */
public class M0949 {

    public static String largestTimeFromDigits(int[] arr) {
        int i1 = arr[0];
        int i2 = arr[1];
        int i3 = arr[2];
        int i4 = arr[3];
        List<int[]> times = new ArrayList<>();

        times.add(new int[]{i1,i2,i3,i4});
        times.add(new int[]{i1,i2,i4,i3});
        times.add(new int[]{i1,i3,i2,i4});
        times.add(new int[]{i1,i3,i4,i2});
        times.add(new int[]{i1,i4,i2,i3});
        times.add(new int[]{i1,i4,i3,i2});

        times.add(new int[]{i2,i1,i3,i4});
        times.add(new int[]{i2,i1,i4,i3});
        times.add(new int[]{i2,i3,i1,i4});
        times.add(new int[]{i2,i3,i4,i1});
        times.add(new int[]{i2,i4,i1,i3});
        times.add(new int[]{i2,i4,i3,i1});

        times.add(new int[]{i3,i1,i2,i4});
        times.add(new int[]{i3,i1,i4,i2});
        times.add(new int[]{i3,i2,i1,i4});
        times.add(new int[]{i3,i2,i4,i1});
        times.add(new int[]{i3,i4,i1,i2});
        times.add(new int[]{i3,i4,i2,i1});

        times.add(new int[]{i4,i1,i2,i3});
        times.add(new int[]{i4,i1,i3,i2});
        times.add(new int[]{i4,i2,i1,i3});
        times.add(new int[]{i4,i2,i3,i1});
        times.add(new int[]{i4,i3,i1,i2});
        times.add(new int[]{i4,i3,i2,i1});


        int[] timeZeros = new int[]{0,0,0,0};
        boolean timeZero = false;
        for (int[] time : times) {

            if (isTime(time)){
                timeZero = true;
                timeZeros = isBigger(timeZeros, time)?time:timeZeros;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(timeZeros[0]);
        stringBuffer.append(timeZeros[1]);
        stringBuffer.append(":");
        stringBuffer.append(timeZeros[2]);
        stringBuffer.append(timeZeros[3]);

        return timeZero?stringBuffer.toString():"";



    }

    public static boolean isTime(int[] time){
        int hour = time[0] * 10 + time[1];
        int minute = time[2] * 10 + time[3];
        return 0<=hour && hour<=23 && 0 <=minute && minute <=59;
    }

    public static boolean isBigger(int[] time,int[] timeNew){
        int hour = time[0] * 10 + time[1];
        int minute = time[2] * 10 + time[3];
        int hourNew = timeNew[0] * 10 + timeNew[1];
        int minuteNew = timeNew[2] * 10+ timeNew[3];
        if (hourNew > hour) {
            return true;
        }
        if (hourNew == hour && minuteNew > minute){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));
        System.out.println(largestTimeFromDigits(new int[]{5,5,5,5}));
        System.out.println(largestTimeFromDigits(new int[]{0,0,1,0}));
    }
}
