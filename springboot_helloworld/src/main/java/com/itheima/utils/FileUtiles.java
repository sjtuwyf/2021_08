package com.itheima.utils;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;

import java.io.File;

/**
 * @author ssqswyf
 * @date 2021/10/26
 */
public class FileUtiles {
    static Encoder encoder = new Encoder();

    static long getDuration(File file){
        if (file.isFile()&&file.getName().endsWith(".mp4")){
            try {
                long duration = encoder.getInfo(file).getDuration();
                return duration;
            } catch (EncoderException e) {
                e.printStackTrace();
            }

        } else if (file.isDirectory()){
            long result = 0;
            for (File listFile : file.listFiles()) {
                result+=getDuration(listFile);
            }
            return result;
        }
        return 0;
    }

    public static void main(String[] args) {
        long duration = getDuration(new File("D:\\study\\拉勾教育-Java工程师高薪训练营mp4\\01 第一阶段 开源框架源码剖析\\模块二 IoC容器设计实现及Spring源码分析\\视频"));
        System.out.println(duration/1000/60);
    }
}
