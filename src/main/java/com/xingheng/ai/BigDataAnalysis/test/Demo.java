package com.xingheng.ai.BigDataAnalysis.test;

import org.apache.logging.log4j.util.StringBuilderFormattable;

import java.util.*;

public class Demo {
    public static void main(String [] args){


        Long l1=100L;
        Long l2=100L;
        Long l3=250L;
        Long l4=250L;
//        System.out.println(l1==l2);
//        System.out.println(l3==l4);
        String a= "lym";

        StringBuffer stringBuffer = new StringBuffer();

        StringBuffer a1 = new StringBuffer("lym");
        StringBuilder a2 = new StringBuilder("lym");

        Stack<String> stack = new Stack();

        ArrayList<String> arrayList  = new ArrayList<>();

        LinkedList<String> linkedList = new LinkedList<>();

        /**
         * 计算ArrayList和LinkedList的增加和查询的时间。
         */

        long startTime = System.currentTimeMillis();

//        for (int i=0;i<1000000;i++){
//            arrayList.add(0,"lym"+i);
//        }

        long endTime = System.currentTimeMillis();

        Long process_time = endTime - startTime;
        System.out.println(process_time);


        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("lym");


        System.out.println(treeSet.size());

        long startTime1 = System.currentTimeMillis();

//        arrayList.stream().filter(e->e.contains("123")).forEach(System.out::println);

//        for (int i=1;i<=100000;i--){
//             a = linkedList.remove(i);
////             System.out.println(a);
//        }

        long endTime1 = System.currentTimeMillis();

        Long process_time1 = endTime1 - startTime1;
        System.out.println(process_time1);

//        System.out.println(arrayList.size());

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("lym");


        Vector<String> vector = new Vector<>();

        vector.add("lym");



        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("lym1");
        linkedHashSet.add("lym2");


        for(String l :linkedHashSet){
            System.out.println(l);
        }
    }
}
