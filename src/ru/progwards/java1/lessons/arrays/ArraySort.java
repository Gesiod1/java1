package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {
    int[]a;
    ArraySort(int[]a){
        sort(a);
    }

    public static  void  sort(int [] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length ; j++) {
                if (a[i] < a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int [] a1 = {5, 6, 2, 1, 8, 11, 43, 3, 3,0, 76};
        ArraySort a2 = new ArraySort(a1);
        System.out.println(Arrays.toString(a1));
    }
}

