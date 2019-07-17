package com.xingheng.ai.BigDataAnalysis.test;

import java.io.*;

/**
 * @Classname IODemo
 * @Description TODO
 * @Date 2019/6/17 3:53 PM
 * @Created by liuyanming
 */
public class IODemo {
    public static void main(String[] args) throws IOException {

        String path = "/Users/liuyanming/data/巴西阿根廷面积.csv";
        /**
         * FileInputStream
         */
//        FileInputStream fileInputStream = new FileInputStream("/Users/liuyanming/data/巴西阿根廷面积.csv");
//
//        byte [] buffer = new byte[1024];
//
//        int hasRead = 0;
//
//        while ((hasRead = fileInputStream.read(buffer))>0){
//            System.out.println(new String(buffer,0,hasRead));
//        };
//        fileInputStream.close();

        /**BufferedReader
         *
         */
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/liuyanming/data/巴西阿根廷面积.csv"));
//
//
//        while (bufferedReader.readLine()!= null){
//            System.out.println(bufferedReader.readLine());
//        }
//
//        bufferedReader.close();
//
        /**
         * FileReader
         */
//        try(FileReader fis= new FileReader("/Users/liuyanming/data/巴西阿根廷面积.csv")){
//            char [] buf = new char[1024];
//            int hasRead = 0;
//            while ((hasRead = fis.read(buf))>0){
//                System.out.println(new String(buf,0,hasRead));
//            }
//        }

        try(
                FileOutputStream fos = new FileOutputStream(path);
                PrintStream ps = new PrintStream(fos);
                ){
            ps.println("普通字符串\n");
            ps.println(new IODemo());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
