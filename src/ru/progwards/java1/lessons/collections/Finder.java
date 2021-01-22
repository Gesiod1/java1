package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {

    //задание 1 - найти 2 соседних числа в коллекции сумма которых минимальна, вернуть коллекцию, содержащую индексы этих чисел
    //метод сравнения для findMinSumPair
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers){
        List<Integer> elemenetsInArray = (ArrayList<Integer>) numbers;
        List<Integer> indexMinElemetns = new ArrayList();
        int minSum = Integer.sum(elemenetsInArray.get(0), elemenetsInArray.get(1));
        int temp = Integer.sum(elemenetsInArray.get(0), elemenetsInArray.get(1));
        for (int i = 0; i < elemenetsInArray.size() - 1; i++) {
            temp = Integer.sum(elemenetsInArray.get(i), elemenetsInArray.get(i + 1));
            if (minSum > temp){
                if (!indexMinElemetns.isEmpty()){
                    indexMinElemetns.clear();
                }
                indexMinElemetns.add(i);
                indexMinElemetns.add(i+1);
                minSum = temp;
            }
        }
        return  indexMinElemetns;
    }

    // задание 2 - найти локальные максимумы - числа, которые больше соседа справа и слева
    public static Collection<Integer> findLocalMax(Collection<Integer> numbers){
        ArrayList<Integer> copyNumbers = new ArrayList<Integer>(numbers); // для использования метода get
        List<Integer> localMacCollection = new ArrayList();
        for (int i = 1; i < numbers.size() - 1; i++) {
            if ((copyNumbers.get(i) > (copyNumbers.get(i - 1)) && copyNumbers.get(i) > (copyNumbers.get(i + 1)))){
                localMacCollection.add(copyNumbers.get(i));
            }
        }
        return localMacCollection;
    }

    //задача 3
    public static boolean findSequence(Collection<Integer> numbers){
        List<Integer> numbersList = (List<Integer>) numbers;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return 1;
                } else if (o1 < o2){
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        numbersList.sort(comparator);
        for (int i = 0; i < numbersList.size(); i++) {
            Integer value = numbersList.get(i);
            if (value != i + 1){
                return false;
            }
        }
        return true;
    }

    //найдите максимальное количество повторяющихся подряд элементов.
    // Результат вернуть в виде строки <элемент>:<количество>, например Василий:5.
    // При равенстве максимального количества у разных повторяющихся элементов, вернуть результат для элемента,
    // повторяющаяся последовательность которого началась с наименьшего индекса.
//    public static String findSimilar(Collection<String> names){
//        List<String> repeat = new ArrayList<String>(); // для записи элемента, который повторяется
//        List<String> repeatMore = new ArrayList<String>(); // для элемента, который повторяется, но повторов пока меньше, чем до этого
//        List<String> namesList = (List<String>) names; // приведение к типу List
//        for (int i = 0; i < names.size() - 1; i++) {
//            if (namesList.get(i).equals(namesList.get(i + 1))) {// сравниваем два элемента
//                if (repeatMore.size() == 0){
//                    repeatMore.add(namesList.get(i));
//                }
////                repeatMore.add(namesList.get(i + 1));
//                if (namesList.size() - 2 == i){
//                    repeatMore.add(namesList.get(i + 1));
//                    if (repeat.size() < repeatMore.size()){
//                        repeat.clear();
//                        for (int j = 0; j < namesList.size(); j++) {
//                            repeat.add(namesList.get(j));
//                        }
//                    }
//                }
//            } else {
//                if (repeat.size() == 0){
//                    repeat.add(namesList.get(i));
//                }
//                if(repeat.size() < repeatMore.size()){
//                    repeat.clear();
//                    for (int j = 0; j < repeatMore.size(); j++) {
//                        repeat.add(repeatMore.get(j));
//                    }
//                }
//                repeatMore.clear();
//            }
//        }
//        String result = "<" + repeat.get(0) + ">:<" + repeat.size() + ">";
//        return result;
//    }

    public static String findSimilar(Collection<String> names) {
        ArrayList<String> arrayCollection = new ArrayList<>(names);
        ArrayList<String> temporaryCollection = new ArrayList<>();
        ArrayList<String> finalCollection = new ArrayList<>();
        for (int i = 0; i < arrayCollection.size() - 1; i++) {
            if (arrayCollection.get(i).equals(arrayCollection.get(i + 1))) {
                if (temporaryCollection.size() == 0){
                    temporaryCollection.add(arrayCollection.get(i));
                }
                temporaryCollection.add(arrayCollection.get(i));
                if (i == arrayCollection.size() - 2) {
                    temporaryCollection.add(arrayCollection.get(i + 1));
                    if (finalCollection.size() < temporaryCollection.size()) {
                        finalCollection.clear();
                        for (int k = 0; k < temporaryCollection.size(); k++) {
                            finalCollection.add(temporaryCollection.get(k));
                        }
                    }
                }
            } else {
                if (finalCollection.size() == 0){
                    finalCollection.add(arrayCollection.get(i));
                }
                if (finalCollection.size() < temporaryCollection.size()) {
                    finalCollection.clear();
                    for (int j = 0; j < temporaryCollection.size(); j++) {
                        finalCollection.add(temporaryCollection.get(j));
                    }
                }
                temporaryCollection.clear();
            }
        }
        String result = finalCollection.get(0) + ":" + finalCollection.size();
        return result;
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{5, 12, 3, 7,-1, -2, 8}));
//        System.out.println(findMinSumPair(list));
//        System.out.println(findLocalMax(list));

        Collection<String> test1 = new ArrayList<>(Arrays.asList(new String[]{"В","Б","Г","Г","Г","Б","Г","Г","А","Г","Б","В","В","Б","Г","В","В"}));
        System.out.println(findSimilar(test1));


    }
}
