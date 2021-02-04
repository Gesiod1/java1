package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetOperations {

    // объединение множеств
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
        HashSet<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    //пересечение множеств
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
        HashSet<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    //разница множеств
    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2){
        HashSet<Integer> retainAllSet = new HashSet<>(set1);
        HashSet<Integer> result = new HashSet<>();
        retainAllSet.retainAll(set2); // пересечение множеств
        for (Integer integer:set1) {
            if (!retainAllSet.contains(integer)){
                result.add(integer);
            }
        }
        return result;
    }

    //симметрическая разница
    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2){
        HashSet<Integer> addAllSet = new HashSet<>(set1);
        HashSet<Integer> retainAllSet = new HashSet<>(set1);
        HashSet<Integer> result = new HashSet<>();
        addAllSet.addAll(set2); //объединение множеств
        retainAllSet.retainAll(set2); // пересечение множеств
        for (Integer integer:addAllSet) {
            if (!retainAllSet.contains(integer)){
                result.add(integer);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> test1 = Set.of(1, 3, 2, 8, 7, 6);
        Set<Integer> test2 = Set.of(4, 5, 9, 1, 3, 2);
//        System.out.println(union(test1, test2));
//        System.out.println(intersection(test1, test2));
//        System.out.println(symDifference(test1, test2));
        System.out.println(difference(test1, test2));

    }
}
