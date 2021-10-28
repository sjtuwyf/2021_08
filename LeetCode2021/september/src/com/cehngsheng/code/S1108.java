package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/9/10
 */
public class S1108 {
    public static void main(String[] args) {
        System.out.println(new S1108().defangIPaddr("1.1.1.1"));

    }

    public String defangIPaddr(String address) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.'){
                stringBuffer.append("[.]");
            } else {
                stringBuffer.append(address.charAt(i));
            }
        }
        return new String(stringBuffer);
    }
}
