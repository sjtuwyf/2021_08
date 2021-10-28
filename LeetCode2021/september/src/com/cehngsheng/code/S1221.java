package com.cehngsheng.code;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;



/**
 * @Author ssqswyf
 * @Date 2021/9/7
 */

public class S1221 {
    private static final Logger logger = LoggerFactory.getLogger(S1221.class);
    public static void main(String[] args) {


        String testExample = "LRRL";
        int i = new S1221().balancedStringSplit(testExample);
        String s = String.valueOf(i);
        logger.debug(s);




    }

    public int balancedStringSplit(String s) {
        int left = 0;
        int right = 0;
        int num = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if ( s.charAt(i) == 'L' ){
                left++;
            } else {
                right++;
            }

            if (left == right ) {
                num++;
            }
        }
        return num;
    }
}
