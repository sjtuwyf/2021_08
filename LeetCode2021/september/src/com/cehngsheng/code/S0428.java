package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/10/4
 */
public class S0428 {
    public static String licenseKeyFormatting(String s, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if ('-' != s.charAt(i)) {
                stringBuffer.append(convertToHigh(s.charAt(i)));
            }
        }
        int length = stringBuffer.length();
        int n = length / k;
        int yv = length % k;
        if (yv == 0 ){
            n = n-1;
            yv = k;
        }
        result.append(stringBuffer.substring(0,yv));
        result.append('-');
        for (int i = 0; i < n; i++) {
            result.append(stringBuffer.substring(yv+i*k, yv+i*k+k));
            result.append('-');
        }
        return result.substring(0, result.length()-1);

    }

    public static char convertToHigh(char c) {
        if ('a' <= c && c <= 'z' ) {
            return  (char) (c-'a'+'A');
        }
        return  c;
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }
}
