package ru.progwards.java1.lessons.collections;

import java.awt.*;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Creator {
    public static Collection<Integer> fillEven(int n){
        List<Integer> list = new ArrayList();
        for (int i = 2; list.size() < n; i++) {
            if (i%2 == 0){
                list.add(i);
            }
        }
        return list;
    }

    public static Collection<Integer> fillOdd(int n){
        List<Integer> list = new ArrayList();
            for (int i = 0; list.size() < n; i++) {
                if (i%2 != 0){
                    list.add(0, i);
                }
            }
            return list;
            // добавить условие, что минимальное число в коллекции 1
    }

    public static Collection<Integer> fill3(int n){
        List<Integer> list = new ArrayList();
        for (int i = 0; list.size()/3 < n; i++) {
            if (i%3 == 0 || i == 0){
                list.add(i);
                list.add(i*i);
                list.add(i*i*i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Creator test = new Creator();
        System.out.println(fillEven(9));
        System.out.println(fillOdd(5));
        System.out.println(fill3(5));

    }
}
