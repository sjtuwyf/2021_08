package com.cehngsheng.code;

/**
 * @Author ssqswyf
 * @Date 2021/9/8
 */
public class S0925 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j) ) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j -1 )) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
