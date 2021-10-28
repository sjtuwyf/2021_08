package com.cehngsheng.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssqswyf
 * @date 2021/10/24
 */
public class S1417 {
    public String reformat(String s) {

        List<Character> list1 = new ArrayList<Character>();
        List<Character> list2 = new ArrayList<Character>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if('a'<=c&&c<='z'){
                list1.add(c);
            }else{
                list2.add(c);
            }


        }
        if(Math.abs(list1.size()-list2.size())>1){
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        if(list1.size()-list2.size()>=0){
            for (int i=0;i<list1.size();i++){
                buffer.append(list1.get(i));
                if (i<list2.size()){
                    buffer.append(list2.get(i));
                }
            }


        } else {
            for (int i=0;i<list2.size();i++){
                buffer.append(list2.get(i));
                if (i<list1.size()){
                    buffer.append(list1.get(i));
                }
            }
        }
        return buffer.toString();

    }
}
