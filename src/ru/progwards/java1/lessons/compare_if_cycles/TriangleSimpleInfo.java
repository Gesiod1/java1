package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c){
        if (a >= b && a >= c){
            return a;
        }
        if ( b >= a && b >= c){
            return  b;
        } else {
            return c;
        }
    }
    public static void main(String[] args) {
        System.out.println(maxSide(5, 6, 3));
    }
}
