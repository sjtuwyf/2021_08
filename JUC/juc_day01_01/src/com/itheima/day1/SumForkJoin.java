package com.itheima.day1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author ssqswyf
 * @Date 2021/8/9
 */
public class SumForkJoin {
    public static class SumTask extends RecursiveTask<Integer> {

        private final static int THRESHOLD = GenArray.ARRAY_LENGTH/10;
        private int[] src;
        private int fromIndex;
        private int endIndex;

        public SumTask(int[] src, int fromIndex, int endIndex) {
            this.src = src;
            this.fromIndex = fromIndex;
            this.endIndex = endIndex;
        }

        @Override
        protected Integer compute() {
            if (endIndex-fromIndex<THRESHOLD){
                int count =0;
                for (int i = fromIndex;i<=endIndex;++i){
                    count+=src[i];
                }
                return count;
            }else {
                int mid = (fromIndex+endIndex)/2;
                SumTask left = new SumTask(src, fromIndex, mid);
                SumTask right = new SumTask(src,mid , endIndex);
                invokeAll(left,right);
                return left.join()+right.join();
            }
        }
    }

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        int[] src = GenArray.genArray();
        SumTask sumTask = new SumTask(src,0,src.length-1);

        long start = System.currentTimeMillis();
        pool.invoke(sumTask);
        System.out.println("spend time: "+(System.currentTimeMillis()-start));
    }
}
