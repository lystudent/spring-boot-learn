package com.xingheng.ai.BigDataAnalysis.test;

import java.util.*;

/**
 * @Classname HashSetDemo
 * @Description TODO
 * @Date 2019/6/12 6:30 PM
 * @Created by liuyanming
 */
public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<Dog> hashSet = new HashSet<>();
        LinkedHashSet<Dog> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Dog> treeSet = new TreeSet<>();
        Random r = new Random();

//        for (String data : Arrays.asList("1","B", "E", "D", "C", "A","2")) {
//            hashSet.add(data);
//            linkedHashSet.add(data);
//            treeSet.add(data);
//        }

//        //不保证有序
//        System.out.println("Ordering in HashSet :" + hashSet);
//
//        //FIFO保证安装插入顺序排序
//        System.out.println("Order of element in LinkedHashSet :" + linkedHashSet);
//
//        //内部实现排序
//        System.out.println("Order of objects in TreeSet :" + treeSet);


        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = r.nextInt(100000- 10) + 10;
            hashSet.add(new Dog(x));
        }

        // end time
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("HashSet: " + duration);

        // start time
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = r.nextInt(100000 - 10) + 10;
            treeSet.add(new Dog(x));
        }
        // end time
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("TreeSet: " + duration);

        // start time
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = r.nextInt(100000 - 10) + 10;
            linkedHashSet.add(new Dog(x));
        }

        // end time
        endTime = System.nanoTime();

        duration = endTime - startTime;
        System.out.println("LinkedHashSet: " + duration);

        System.out.println(r.nextInt(100000 - 10) + 10);



    }
}
