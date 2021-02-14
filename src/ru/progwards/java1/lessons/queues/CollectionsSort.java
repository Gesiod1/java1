package ru.progwards.java1.lessons.queues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsSort {
    //1.1 Реализовать метод public static void mySort(Collection<Integer> data) -
    // переделать алгоритм из класса ArraySort из ДЗ про массивы, на коллекции.
    // Не использовать встроенные методы сортировок

    public static void mySort(Collection<Integer> data){
        List<Integer> dataList = new ArrayList<>();
        int count = 0;
        for (Integer i: data) {
            dataList.add(count, i);
            count++;
        }
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = 0; j < dataList.size(); j++) {
                if (j < i){
                    Collections.swap(dataList, dataList.get(j), dataList.get(i));
                }
            }
        }
        data.removeAll(data);
        Collections.addAll(data, dataList);
    }
}
