package com.xingheng.ai.BigDataAnalysis.servlet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname ArrayListDemo
 * @Description TODO
 * @Date 2019/6/12 3:11 PM
 * @Created by liuyanming
 */
public class ArrayListDemo {

    static final int N = 50000;

    static Long timeList(List list ){
        long starttime = System.currentTimeMillis();
        Object o = new Object();
        for(int i=1;i<N;i++){
            list.add(0,o);
        }
        return System.currentTimeMillis()-starttime;
    }

    static Long readList(List list){
        long starttime = System.currentTimeMillis();
        Object o = new Object();
        for(int i=1;i<N;i++){
            o = list.get(i);
        }
        return System.currentTimeMillis()-starttime;
    }

    static List addList(List list){
        Object o = new Object();
        for(int i=0;i<N;i++) {
            list.add(0, o);
        }
        return list;
    }

    public static void  main(String [] args){
        System.out.println("ArrayList添加"+N+"条耗时："+timeList(new ArrayList()));
        System.out.println("LinkedList添加"+N+"条耗时："+timeList(new LinkedList()));

        List list1=addList(new ArrayList<>());
        List list2=addList(new LinkedList<>());
        System.out.println("ArrayList查找"+N+"条耗时："+readList(list1));
        System.out.println("LinkedList查找"+N+"条耗时："+readList(list2));
    }
}
