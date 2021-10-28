package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/9/15
 */
public class S1154 {
    public int dayOfYear(String date) {
        String[] split = date.split("-");

        int[] dayCount = new int[13];
        dayCount[0] = 0;
        dayCount[1] = 31;
        dayCount[2] = 28;
        dayCount[3] = 31;
        dayCount[4] = 30;
        dayCount[5] = 31;
        dayCount[6] = 30;
        dayCount[7] = 31;
        dayCount[8] = 31;
        dayCount[9] = 30;
        dayCount[10] = 31;
        dayCount[11] = 30;
        int year = Integer.valueOf(split[0]);

        int month = Integer.valueOf(split[1]);
        int day = Integer.valueOf(split[2]);
        System.out.println("" + year + " " + month + " " + day);
        int res = 0;
        for (int i = 0;i<month;i++){
            res+=dayCount[i];
        }
        return res + isRun(year) + day;



    }

    public int isRun(int year){
        if (year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0){
                    return 1;
                }
                return 0;
            }
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new S1154().dayOfYear("2011-12-01"));
    }
}
