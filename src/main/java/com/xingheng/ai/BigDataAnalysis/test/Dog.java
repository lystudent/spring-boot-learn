package com.xingheng.ai.BigDataAnalysis.test;

import java.util.Comparator;

/**
 * @Classname Dog
 * @Description TODO
 * @Date 2019/6/13 11:02 AM
 * @Created by liuyanming
 */
public class Dog  implements Comparable<Dog> {

    int old ;

    public Dog(int s){
        old = s;
    }

    @Override
    public String toString() {
        return  old+"";
    }


    @Override
    public int compareTo(Dog o) {
        return old -o.old;
    }
}
