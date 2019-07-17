package com.xingheng.ai.BigDataAnalysis.test;

import io.swagger.models.auth.In;

import java.math.BigInteger;

/**
 * @Classname IntDemo
 * @Description TODO
 * @Date 2019/6/14 10:33 AM
 * @Created by liuyanming
 */
public class IntDemo {
    public static void main(String[] args) {
        int i = 100;

        int low = i & 0xFF;
        int high = i >>> 8;

        System.out.println("---------------------------------");
        System.out.println("i：" + i);
        System.out.println("i：" + Integer.toBinaryString(i));
        System.out.println("---------------------------------");
        System.out.println("低位 low：" + low);
        System.out.println("低位 low：" + Integer.toBinaryString(low));
        System.out.println("---------------------------------");
        System.out.println("低位 high：" + high);
        System.out.println("低位 high：" + Integer.toBinaryString(high));
        System.out.println("---------------------------------");
//        System.out.println(0xff);
    }

    public static String getFullBinaryString(int num){
        String s = Integer.toBinaryString(num);
        String format = String.format("%032d", new BigInteger(s));
        return format;
    }

}
