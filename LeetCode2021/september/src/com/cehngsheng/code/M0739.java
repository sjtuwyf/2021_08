package com.cehngsheng.code;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author ssqswyf
 * @Date 2021/9/3
 */
public class M0739 {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] tempIncrease = new int[length];
        for (int i = 0; i< length;i++){
            tempIncrease[i] = -1;
        }
        tempIncrease[length-1] = 0;
        int tryNum = 0;
        for (int i = length-2; i >= 0; i--) {
            tryNum = i + 1;
            while (temperatures[i] >= temperatures[tryNum]    ) {
                if (tempIncrease[tryNum] == 0) {
                    tempIncrease[i] = 0;
                    break;
                }
                tryNum += tempIncrease[tryNum];
            }
            if (tempIncrease[i] == 0){
                continue;
            }

            tempIncrease[i] = tryNum - i;

        }

        return tempIncrease;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i=0;i<length;i++){
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }


}

