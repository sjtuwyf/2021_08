package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/10/7
 */
public class S0434 {
    public static int countSegments(String s) {
        int result = 0;
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        if (s.charAt(0)!=' ') {
            result++;
        }
        for (int i = 1; i < length; i++) {
            if (s.charAt(i-1) == ' ' && s.charAt(i)!=' ' ){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }
}
