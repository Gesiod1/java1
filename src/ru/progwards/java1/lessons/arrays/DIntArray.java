package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int [] origin_array;

    public void add(int num){ // добавляет элемент num  в конец массива
        int [] copy_array = Arrays.copyOf(origin_array, origin_array.length + 1); // создаем копию массива
        copy_array[origin_array.length + 1] = num; // добавляем последним элементом num
        origin_array = copy_array;
    }
    public int [] return_array(int num){
        return origin_array;
    }

    public void atInsert(int pos, int num){ // добавляет элемент num в позицию pos массива
//        int [] copy_array = Arrays.copyOf(origin_array, origin_array.length + 1); // создали его копию
//        copy_array[pos] = num; // кладем значение num с индексом pos в новую копию
//        for (int pos, n = copy_array.length; pos < n; pos++) {// сдвинаем массив после добавления элемента
//           copy_array[pos + 1] = origin_array[pos];
//        }
//        origin_array = copy_array;
    }

    public void atDelete(int pos){ //удаляет элемент в позиции pos массива
    }

    public int at(int pos){ //возвращает элемент по индексу pos
        return origin_array[pos];
    }

    public static void main(String[] args){
        int [] a1 = {3, 5, 1, 0, 7};
    }
}
