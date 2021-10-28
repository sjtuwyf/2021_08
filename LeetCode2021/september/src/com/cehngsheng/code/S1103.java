package com.cehngsheng.code;

/**
 * @author ssqswyf
 * @date 2021/9/14
 */
public class S1103 {


    public int[] distributeCandies(int candies, int num_people) {
        int num = candies;
        int[] ans = new int[num_people];
        int candyNUm = 0;
        for (int i = 0; i <num; i++) {
            for (int j =0; j<num_people;j++) {
                candyNUm = i * num_people + j + 1;
                if (candies >= candyNUm) {
                    ans[j] += candyNUm;
                    candies -= candyNUm;
                } else {
                    ans[j] += candies;
                    candies = 0;
                    return ans;
                }


            }
        }
        return ans;
    }
}
