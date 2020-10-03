package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int [] arrayInt  = new int [2];

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
        int [] arrayPos = new int [1];
        System.arraycopy(arrayInt, pos, arrayPos, 0, 1);
        pos = arrayPos[0];
        return pos;
    }

    public static void main(String[] args){
        DIntArray a2 = new DIntArray();
        System.out.println(a2);
        a2.add(5);
        a2.add(89);
        a2.add(32);
        System.out.println(a2);
        a2.atInsert(3, 13);
        System.out.println(a2);
        a2.atDelete(3);
        System.out.println(a2);
        a2.atDelete(0);
        a2.atDelete(0);
        System.out.println(a2);
        System.out.println(a2.at(1));
    }
}
