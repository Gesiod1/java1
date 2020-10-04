package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int [] arrayInt  = new int [0];

    public void add(int num){ // добавляет элемент num  в конец массива
        int [] arrayIntCopy = Arrays.copyOf(arrayInt, arrayInt.length + 1); // создаем копию массива
        arrayIntCopy[arrayInt.length] = num; // добавляем последним элементом num
        arrayInt = arrayIntCopy;
    }

    public int[] getArrayInt() {
        return arrayInt;
    }

    @Override
    public String toString() {
        return "DIntArray{" +
                "arrayInt=" + Arrays.toString(arrayInt) +
                '}';
    }

    public void atInsert(int pos, int num){ // добавляет элемент num в позицию pos массива
        int [] arrayIntCopy = Arrays.copyOf(arrayInt, arrayInt.length + 1);
        arrayIntCopy [pos] = num;
        System.arraycopy(arrayInt, pos, arrayIntCopy, pos + 1, arrayInt.length - pos);
        arrayInt = arrayIntCopy;
    }

    public void atDelete(int pos){ //удаляет элемент в позиции pos массива
        int [] arrayCopy = new int [arrayInt.length - 1];
        System.arraycopy(arrayInt, 0, arrayCopy, 0, pos);
        System.arraycopy(arrayInt, pos + 1, arrayCopy, pos, arrayInt.length - pos - 1);
        arrayInt = arrayCopy;
    }

    public int at(int pos){ //возвращает элемент по индексу pos
        return arrayInt[pos];
    }

    public static void main(String[] args){
        DIntArray a2 = new DIntArray();
        a2.add(27);
        a2.add(-3);
        a2.add(96);
        a2.add(55);
        a2.add(-8);
        a2.add(-88);
        a2.add(-56);
        a2.add(-65);
        a2.add(40);
        a2.add(-50);
        a2.add(64);
        a2.add(-24);
        a2.add(69);
        System.out.println(a2);
        a2.atDelete(10);
        System.out.println(a2.at(10));
    }
}
