package com.leetcode;

/**
 * @Author ssqswyf
 * @Date 2021/8/30
 */
public class _0106 {
    public static void main(String[] args) {

    }

    public String compressString(String S) {
        int n = S.length();
        if(n<=2){
            return S;
        }
        StringBuffer buffer = new StringBuffer();
        char c = S.charAt(0);
        int cNum = 0;
        for (int i = 0;i < n; i++) {
            if (c == S.charAt(i)) {
                cNum++;
            } else {
                buffer.append(""+c+cNum);
                c = S.charAt(i);
                cNum = 1;
            }
        }
        buffer.append(""+c+cNum);
        if(buffer.length()>=n){
            return S;
        }
        return buffer.toString();

    }
}
