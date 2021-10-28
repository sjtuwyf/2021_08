package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/9/24
 */
public class S0507 {

    public static boolean checkPerfectNumber(int num) {
        if (num < 6) {
            return false;
        }

        int sum = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum==num;

    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(6));
    }
}
