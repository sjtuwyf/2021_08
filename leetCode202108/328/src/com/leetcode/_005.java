package com.leetcode;

/**
 * @Author ssqswyf
 * @Date 2021/8/19
 */
public class _005 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
    }

        public static String longestPalindrome(String s) {
            int length = s.length();
            if (length < 2) {
                return s;
            }
            int maxLength = 1;
            int begin = 0;

            boolean[][] dp = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }

            char[] charArray = s.toCharArray();

            for (int L = 2; L <= length; ++L ){
                for (int i = 0; i < length; i++) {
                    int j = i + L  -1;
                    if (j>=length){
                        break;
                    }
                    if (charArray[i]!=charArray[j]){
                        dp[i][j]=false;
                    } else {
                        if (L<2) {
                            dp[i][j]=true;
                        } else {
                            dp[i][j]=dp[i+1][j-1];

                        }
                    }

                    if (dp[i][j] && L>maxLength){
                        maxLength = L;
                        begin = i;
                    }
                }
            }

            return  s.substring(begin, begin+maxLength);
        }


}
