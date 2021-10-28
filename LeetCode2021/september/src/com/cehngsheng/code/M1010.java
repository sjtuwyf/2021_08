package com.cehngsheng.code;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;

/**
 * @author ssqswyf
 * @date 2021/9/25
 */
public class M1010 {
    public static int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        ArrayList<ArrayList<Integer>> help = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 60; i++) {
            help.add(new ArrayList<Integer>());
        }

        int t = 0;
        for (int i = 0; i < n; i++ ) {
            t = time[i] % 60;
            ArrayList<Integer> integers1 = help.get(t);
            integers1.add(i);
            help.set(t,integers1);
        }
        int res0 = 0;
        int res30 = 0;
        if (help.get(0).size()>=2) {
            res0 = help.get(0).size() * (help.get(0).size() - 1) / 2;
        }
        if (help.get(30).size()>=2) {
            res0 = help.get(30).size() * (help.get(30).size() - 1) / 2;
        }
        int res = res0 + res30;
        for (int  i = 1; i < 30; i++){
            res += help.get(i).size()*help.get(60-i).size();
        }
        return res;
    }

    public static int numPairsDivisibleBy60_2(int[] time) {
        int count = 0;
        int[] seconds = new int[60];
        for (int i : time) {
            seconds[i%60] += 1;
        }
        count+=com(seconds[0],2);
        count+=com(seconds[30],2);
        int i = 1, j = 59;
        while(i < j) {
            count += seconds[i++] * seconds[j--];
        }
        return count;



    }
    public static int com(int n , int k){
        long result = 1;
        for(int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return (int)result;

    }

    public static  void main(String[] args) {
        System.out.println(numPairsDivisibleBy60_2(new int[]{30, 20, 150, 100, 40}));
    }
}
