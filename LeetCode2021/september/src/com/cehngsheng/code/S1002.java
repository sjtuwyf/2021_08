package com.cehngsheng.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssqswyf
 * @date 2021/10/27
 */
public class S1002 {

    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[] min = new int[26];
        for (int i=0;i<26;i++){
            min[i]=-1;
        }
        int[][] count = new int[n][26];
        for (int i=0;i<n;i++){
            String s = words[i];
            for (int j=0;j<s.length();j++){
                count[i][s.charAt(j)-'a']++;
            }
            for (int k=0;k<26;k++){
                if (min[k]==-1){
                    min[k]=count[i][k];
                } else if (min[k]>count[i][k]){
                    min[k]=count[i][k];
                }
            }
        }

        List<String> res = new ArrayList<String>();
        for (int i=0;i<26;i++){
            int num = min[i];
            for (int j=0;j<num;j++){

                res.add(String.valueOf((char)('a'+i)));
            }
        }
        return res;

    }
}
