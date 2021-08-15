package org.example;

import java.util.Arrays;

/**
 * @Author ssqswyf
 * @Date 2021/8/14
 */
public class SortTest {

     public static void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,0,2,0,1};
//        System.out.println(Arrays.toString(nums));
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//
//        int x = 123;
//        System.out.println(String.valueOf(x).length());
        System.out.println(countAndSay("21"));


    }

    public static String countAndSay(String str) {
         int x = 0;
         char ch = str.charAt(0);
         StringBuffer stringBuffer = new StringBuffer();

         for (int i = 0;i < str.length();i++){
             if (ch==str.charAt(i)){
                 x++;

             }
             if (ch != str.charAt(i)){
                 stringBuffer.append(String.valueOf(x));
                 stringBuffer.append(ch);
                 ch = str.charAt(i);
                 x=1;
             }
         }
        stringBuffer.append(String.valueOf(x));
        stringBuffer.append(ch);
        return stringBuffer.toString();

    }


}
