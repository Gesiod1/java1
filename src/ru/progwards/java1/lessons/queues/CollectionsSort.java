package ru.progwards.java1.lessons.queues;

import java.util.*;

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
        data.removeAll(data);
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = 0; j < dataList.size(); j++) {
                if (dataList.get(j) > dataList.get(i)){
                    Collections.swap(dataList, i, j);
                }
            }
        }
        for (Integer i: dataList) {
            data.add(i);
        }
    }
    //1.2 Реализовать метод public static void minSort(Collection<Integer> data) по следующему алгоритму
    //- создать новую коллекцию
    //- найти минимальный элемент с использованием функции min()
    //- переместить его в новую коллекцию
    //- делать так до тех пор, пока все элементы не окажутся в новой коллекции
    //- скопировать новую коллекцию в старую
    public static void minSort(Collection<Integer> data){
        List<Integer> newListWithMinElements = new ArrayList<>();
        while (data.size() > 0){
            Integer i = Collections.min(data);
            newListWithMinElements.add(i);
            data.remove(i);
        }
        data.addAll(newListWithMinElements);
    }

    //1.3 / Реализовать метод public static void collSort(Collection<Integer> data) используя метод sort из Collections
    public static void collSort(Collection<Integer> data){
        List<Integer> dataSort = new ArrayList<>();
        for (Integer e: data) {
            dataSort.add(e);
        }
        Collections.sort(dataSort);
        data.removeAll(data);
        data.addAll(dataSort);
    }

    // 1.4 Реализовать метод public static Collection<String> compareSort()
    // в котором сравнить производительность методов и вернуть их имена, отсортированные
    // в порядке производительности, первый - самый быстрый. В случае равенства производительности
    // каких-то методов,возвращать их названия в алфавитном порядке.
    public static Collection<String> compareSort(){
        final int ELEMENTS_COUNT = 20000;
        Collection<Integer> testMySort = new ArrayList<>();
        Collection<Integer> testMinSort = new ArrayList<>();
        Collection<Integer> testCollSort = new ArrayList<>();

        var startTime = new Date().getTime();
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            testMySort.add(i);
            testMinSort.add(i);
            testCollSort.add(i);
        }
        Collections.shuffle((List<?>) testMySort);
        Collections.shuffle((List<?>) testMinSort);
        Collections.shuffle((List<?>) testCollSort);
//        System. out.println( "добавление: " + (new Date().getTime() - startTime));
        startTime = new Date().getTime();
        mySort(testMySort);
//        System. out.println( "mySort: " + (new Date().getTime() - startTime));
        startTime = new Date().getTime();
        minSort(testMinSort);
//        System. out.println( "minSort: " + (new Date().getTime() - startTime));
        startTime = new Date().getTime();
        collSort(testCollSort);
//        System. out.println( "collSort: " + (new Date().getTime() - startTime));
        Collection<String> result = new ArrayList<>(List.of("collSort", "mySort", "minSort"));
        return result;
    }

    public static void main(String[] args) {
//        Collection<Integer> test = new ArrayList<>(List.of(4, 9, 5, 1, 2, 2, 3));
//        mySort(test);
//        minSort(test);
//        collSort(test);
//        System.out.println(test);

    }
}
