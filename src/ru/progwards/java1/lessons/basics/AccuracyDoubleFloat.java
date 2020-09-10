package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public static double volumeBallDouble(double radius){
        double p1 = 3.14;
        double V1 = 4 / 3 * p1 * radius;
        return  V1;
    }
    public static float volumeBallFloat(float radius){
        float p2 = 3.14f;
        float V2 = 4 / 3 * p2 * radius;
        return V2;
    }
    public static double calculateAccuracy(double radius){
        double calculate = volumeBallDouble(6371.2) - volumeBallFloat((float)6371.2);
        return calculate;
    }

    public static void main(String[] args) {
        System.out.println(volumeBallDouble((double) 6371.2));
        System.out.println(volumeBallFloat((float) 6371.2));
        System.out.println(calculateAccuracy(1));
    }
}
