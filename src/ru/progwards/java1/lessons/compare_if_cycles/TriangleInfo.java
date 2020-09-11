package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c){
        int frontA = b + c;
        int frontB = a + c;
        int frontC = a + b;
        if (a < frontA && b < frontB && c < frontC){
            return true;
        } else  {
            return false;
        }
    }
    public static boolean isRightTriangle(int a, int b, int c){
        int angleA = b * b + c * c;
        int angleB = a * a + c * c;
        int angleC = a * a + b * b;
        if (a * a == angleA || b * b == angleB || c *c == angleC){
            return true;
        } else {
            return false;
        }
    }
    public static boolean isIsoscelesTriangle(int a, int b, int c){
        if (a == b || a == c || b == c){
            return true;
        } else {
            return  false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isIsoscelesTriangle(3, 4, 4));
    }
}
