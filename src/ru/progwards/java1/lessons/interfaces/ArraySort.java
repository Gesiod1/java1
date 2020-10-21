package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort {
//    public static  void  sort(int [] a){
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a.length ; j++) {
//                if (a[i] < a[j]){
//                    int tmp = a[i];
//                    a[i] = a[j];
//                    a[j] = tmp;
//                }
//            }
//        }
//    }
    public static void sort(CompareWeight[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length ; j++) {
                if (a[i].compareWeight(a[j]) == CompareWeight.CompareResult.LESS){
                    CompareWeight tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Food[] a1 = {new Food(43), new Food(12)};
        sort(a1);
        System.out.println(Arrays.toString(a1));
    }
}
