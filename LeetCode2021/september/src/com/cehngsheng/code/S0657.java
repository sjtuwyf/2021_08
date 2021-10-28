package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/10/16
 */
public class S0657 {
    public boolean judgeCircle(String moves) {
        int[] ints = new int[]{0, 0};
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i)=='R'){
                ints[0]++;
            }
            if (moves.charAt(i)=='L'){
                ints[0]--;
            }
            if (moves.charAt(i)=='U'){
                ints[1]++;
            }
            if (moves.charAt(i)=='D'){
                ints[1]--;
            }


        }
        if (ints[0]==0&&ints[1]==0){
            return true;
        }
        return false;

    }
}
