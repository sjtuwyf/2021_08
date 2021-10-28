package com.cehngsheng.code;

import java.util.*;

/**
 * @author ssqswyf
 * @date 2021/10/8
 */
public class M0187 {

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> strings = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> setRes = new HashSet<>();
        int length = s.length();
        System.out.println(length);
        if (length<=10){
            return strings;
        }
        StringBuffer stringBuffer = new StringBuffer(s.substring(0, 10));
        System.out.println(stringBuffer);
        String toString = "";
        System.out.println("--------");
        for (int i = 0; i <= length - 10; i++) {
            stringBuffer.delete(0, 10);
            stringBuffer.append(s.substring(i, i+10));
            toString = stringBuffer.toString();
            System.out.println(toString);
            if (!set.contains(toString)) {
                set.add(toString);
            } else {
                setRes.add(toString);
            }

        }
        for (String setRe : setRes) {
            strings.add(setRe);
        }
        return strings;
    }

    public static void main(String[] args) {
        for (String s : findRepeatedDnaSequences("AAAAAAAAAAA")) {
            System.out.println(s);
        }
    }
}
