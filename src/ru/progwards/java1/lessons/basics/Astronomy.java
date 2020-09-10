package ru.progwards.java1.lessons.basics;

public class Astronomy {
    public static Double sphereSquare(Double r){
        double p = 3.14;
        double S = 4 * p * r * r; // площадь поверхности сферы
        return S;
    }
    public static Double earthSquare(){
        double earth = sphereSquare((double) 6371.2); // площадь Земли
        return earth;
    }
    public static Double mercurySquare(){
        double mercury = sphereSquare((double) 2439.7); // площадь Меркурия
        return  mercury;
    }
    public static Double jupiterSquare(){
        double jupiter = sphereSquare((double) 71492); // площадь Юпитера
        return  jupiter;
    }
    public static Double earthVsMercury(){
        double earthVsMercury1 = earthSquare() / mercurySquare();// отношение площади Земли к площади Меркурия
        return  earthVsMercury1;
    }
    public static Double earthVsJupiter(){
        double earthVsJupiter1 = earthSquare() / jupiterSquare(); // отношение площади Земли к площади Юпитера
        return  earthVsJupiter1;
    }

    public static void main(String[] args) {
        System.out.println(earthSquare());
        System.out.println(mercurySquare());
        System.out.println(jupiterSquare());
        System.out.println(earthVsMercury());
        System.out.println(earthVsJupiter());
    }
}
