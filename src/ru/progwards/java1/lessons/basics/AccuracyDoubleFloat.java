package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public static double volumeBallDouble(double radius){
        double p1 = (double) 3.14;
        double constDouble = (double) 4 / 3;
        double V1 = constDouble * p1 * radius * radius * radius;
        return  V1;
    }
    public static float volumeBallFloat(float radius){
        float p2 = (float) 3.14f;
        float constFloat = (float) 4 / 3;
        float V2 = constFloat * p2 * radius * radius * radius;
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
