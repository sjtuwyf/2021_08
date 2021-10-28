package com.cehngsheng.code;

import java.io.File;
import java.util.List;

/**
 * @author ssqswyf
 * @date 2021/10/15
 */
public class S0892 {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int c = 0;
        int d = 0;
        int a = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]>0){
                    c+=grid[i][j]-1;
                }
                a+=grid[i][j];
            }
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n- 1; j++) {
                d+=Math.min(grid[i][j],grid[i][j+1]);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                d+=Math.min(grid[i][j],grid[i+1][j]);
            }
        }
        System.out.println(a);
        System.out.println(c);
        System.out.println(d);
        return 6*a-2*c-2*d;


    }

    public static void fileDirs(File file) {
        if (file.exists()){
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    fileDirs(file1);
                }
            } else {
//                System.out.println(file.getName());

                String[] split = file.getName().split("[.]");
                if (split[0].endsWith("(1)")){

                    System.out.println(file.getName());

                    if (file.exists()){
//                        file.delete();
                    }

                }
//                if (file.exists()&&file.getName().endsWith("(1).vep")){
//                    System.out.println(file.getName());
////                    file.delete();
//                }
            }
        }
    }
    public static Long getSize(File file){
        Long res = 0L;
        if (file.exists()){
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    res+=getSize(file1);
                }
            } else {
                res+=file.length();
            }
        }
        return res;
    }
    public static Long getDirNum(File file){
        Long res = 0L;
        if (file.exists()){
            if (file.isDirectory()) {
                res++;
                File[] files = file.listFiles();
                for (File file1 : files) {
                    res+=getDirNum(file1);
                }
            } else {

            }
        }
        return res;
    }
    public static Long getFileNum(File file){
        Long res = 0L;
        if (file.exists()){
            if (file.isDirectory()) {

                File[] files = file.listFiles();
                for (File file1 : files) {
                    res+=getFileNum(file1);
                }
            } else {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        File file = new File("G:\\9马士兵MCA最新课程");
        System.out.println(file.length());
        System.out.println(getDirNum(file));
        System.out.println(getFileNum(file));
        System.out.println(getSize(file));
        System.out.println(getSize(file)/1024/1024/1024);

        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getName()+": "+getDirNum(file1)+" "+getFileNum(file1)+" "+getSize(file1)+" "+((double)getSize(file1))/1024/1024/1024);
        }


//        fileDirs(file);
    }
}
