package com.leetcode;

/**
 * @Author ssqswyf
 * @Date 2021/8/29
 */
public class _0103 {
    public static void main(String[] args) {

//        "      dsfasdfasdfas               "
//        19
//        System.out.println(new _0103().replaceSpaces("               ", 5));
//        System.out.println(new _0103().replaceSpaces("Mr John Smith    ", 13));
        System.out.println(new _0103().replaceSpaces("      dsfasdfasdfas               ", 19));
    }

    public String replaceSpaces(String S, int length) {
        String substring = S.substring(0, length);
        int startNull = 0;
        int endNull = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == ' ' ) {
                startNull++;
            } else {
                break;
            }
        }
        for (int i = substring.length()-1;i>=0;i--){
            if (substring.charAt(i) == ' ' ) {
                endNull++;
            } else {
                break;
            }
        }
        String[] split = substring.split(" ");

        StringBuffer buffer = new StringBuffer();
        if (split.length == 0 ){
            for (int i = 0; i < length; i++) {
                buffer.append("%20");
            }
            return buffer.toString();
        }

        for (int i = 0; i < startNull; i++) {
            buffer.append("%20");
        }
        for (int i = 0; i < split.length; i++) {
            buffer.append(split[i]);
            if (i != split.length-1) {
                buffer.append("%20");
            }
        }
        for (int i = 0; i < endNull; i++) {
            buffer.append("%20");
        }
        System.out.println(startNull);
        System.out.println(endNull);
        String toString = buffer.toString();
        return toString;

    }

}
