package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/9/29
 */
public class S0504 {
    public static String convertToBase7(int num) {
        if (num==0){
            return "0";
        }
        boolean isNegative = false;
        StringBuffer s = new StringBuffer();
        if(num < 0){
            isNegative = true;
        }
        num =Math.abs(num);
        int remainder = 0;
        while (num > 0) {
            remainder = num % 7;
            s.append(remainder);
            num/=7;
        }
        if (isNegative) {
            s.append("-");
        }
        s.reverse();
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
        System.out.println(convertToBase7(0));
    }
}
