package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Comparator;

public class Finder {

    //задание 1
    //метод сравнения
    private static List<Integer> compareArrayElements (Object[] elemenetsInArray){
        List<Integer> indexMinElemetns = new ArrayList();
        //сумма первых двух элементов
        int minSum = Integer.sum((int) elemenetsInArray[0], (int) elemenetsInArray[1]) ;
        //ищем минимальную сумму через сравнение
        for (int i = 1; i < elemenetsInArray.length - 1; i++) {
           if (minSum > ((int) elemenetsInArray[i]) + ((int) elemenetsInArray[i + 1])){
              if (!indexMinElemetns.isEmpty()){
                  indexMinElemetns.remove(0);
                  indexMinElemetns.remove(0);
              }
              indexMinElemetns.add(0, i);
              indexMinElemetns.add(1, i + 1);
           }
        }
        return  indexMinElemetns;
    }
    //найти 2 соседних числа в коллекции сумма которых минимальна, вернуть коллекцию, содержащую индексы этих чисел
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers){
        Object[] numbersArray = numbers.toArray();
        List<Integer> indexMinElements = compareArrayElements(numbersArray);
        return indexMinElements;
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList();
        test.add(1);
        test.add(6);
        test.add(10);
        test.add(4);
        test.add(2);
        System.out.println(findMinSumPair(test));
    }
}
