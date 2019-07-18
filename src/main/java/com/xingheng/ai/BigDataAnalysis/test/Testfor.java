package com.xingheng.ai.BigDataAnalysis.test;

import org.apache.commons.lang3.StringUtils;
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
//        System.out.println(swapWords1(s));
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }


    public  static void swap( ArrayList<String>  arr,int begin,int end){
        while (begin<end){
            String temp = arr.get(begin);
            arr.set(begin,arr.get(end)) ;
            arr.set(end,temp);
            begin++;
            end--;
        }


    }


    /**
     * 先反转字符串，再根据单词反转
     */
//    public static String swapWords(String str){
//        char [] arr = str.toCharArray();
//        swap(arr,0,arr.length-1);
//        int begin = 0;
//        for (int i =1;i<arr.length;i++){
//            if(arr[i] == ' '){
//                swap(arr,begin,i-1);
//                begin = i+1;
//            }
//        }
//        swap(arr,begin,arr.length-1);
//        return new String(arr);
//    }

    /**
     * 先将字符串分割,再反转
     */
//
//    public static StringBuilder swapWords1(String str){
//        char [] arr1 = str.toCharArray();
//
//        ArrayList<String>   arr = new ArrayList<String>();
//        String a = "";
//        for(int i=0;i<arr1.length;i++){
//            a+=arr1[i];
//            if (arr1[i]==' '){
//                arr.add(a);
//                a="";
//            }
//        }
//        arr.add(a);
//
//        long startTime = System.nanoTime();
//        swap(arr,0,arr.size()-1);
//
//        StringBuilder  stringBuffer = new StringBuilder();
////        for (int i =0;i<arr.size();i++){
////            stringBuffer.append(arr.get(i)+" ");
////        }
//         for(String i :arr){
//             stringBuffer.append(i+" ");
//         }
////        String s = StringUtils.join(arr," ");
//        long endTime = System.nanoTime();
//        System.out.println(endTime-startTime);
//        return stringBuffer ;
//    }



}
