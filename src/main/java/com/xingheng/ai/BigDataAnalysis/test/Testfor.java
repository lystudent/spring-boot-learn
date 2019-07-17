package com.xingheng.ai.BigDataAnalysis.test;

import org.apache.el.stream.Stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 测试++ --
 * @Description TODO
 * @Date 2019/7/16 11:12 AM
 * @Created by liuyanming
 */
public class Testfor {
    public static void main(String[] args) {

        /**
         * 变量取值，超过以后从最小的开始
         */
//        int count = 0;
//        int STARTNUMBER = 2147483645;
//        int ENDNUMBER = 2147483647 ;
//
////        int STARTNUMBER = 45;
////        int  ENDNUMBER = 47 ;
//
//        for(int i = STARTNUMBER; i<=ENDNUMBER;i++){
//            System.out.println(i);
//            count++;
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//        System.out.println(count);

        /**
         * asList 返回定长数组
         */
//        String [] arr = new String [] {"zs","ls","ww"};
//        List<String> list = Arrays.asList(arr);
//        list.set(1,"zy");
//        System.out.println(list.size());
//        System.out.println(list);


        /**
         *
         */

        long startTime = System.nanoTime();
        String s = "liu yan ming liu shan bing";
        System.out.println(swapWords(s));
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }


    public  static void swap( char [] arr,int begin,int end){
        while (begin<end){
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }


    }

    public static String swapWords(String str){
        char [] arr = str.toCharArray();
        swap(arr,0,arr.length-1);
        int begin = 0;
        for (int i =1;i<arr.length;i++){
            if(arr[i] == ' '){
                swap(arr,begin,i-1);
                begin = i+1;
            }
        }
        swap(arr,begin,arr.length-1);
        return new String(arr);
    }

//    public static StringBuffer swapWords1(String str){
//        String  []  arr = str.split(" ");
//        swap(arr,0,arr.length-1);
//
//        StringBuffer  stringBuffer = new StringBuffer();
//        for (int i =0;i<arr.length;i++){
//            stringBuffer.append(arr[i]+" ");
//        }
//        return stringBuffer;
//    }



}
