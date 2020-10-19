package ru.progwards.java1.lessons.interfaces;

import ru.progwards.java1.lessons.interfaces.FoodCompare;
import ru.progwards.java1.lessons.interfaces.Hamster;

import java.util.Objects;

public class Animal implements FoodCompare, CompareWeight{ // сохраняем вес животного
    double weight;
    public Animal(double weight){
        this.weight = weight;
    }

    enum AnimalKind { // вид животного
        ANIMAL, COW, HAMSTER, DUCK
    }

    public AnimalKind getKind(){ // функция, возвращает вид животного
        return AnimalKind.ANIMAL;
    }

    @Override
    public CompareResult compareWeight(double smthHasWeigt) {
        if (this.getWeight() == smthHasWeigt){
            return CompareResult.EQUALS;
        } else if (this.getWeight() < smthHasWeigt){
            return CompareResult.LESS;
        } return CompareResult.GREATER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
    enum FoodKind { // еда живтоного
        UNKNOWN, HAY, CORN
    }
    // Объявляем переменные
//    FoodKind foodKind_unknown = FoodKind.UNKNOWN;
    FoodKind foodKind_hay = FoodKind.HAY;
    FoodKind foodKind_corn = FoodKind.CORN;

    public double getFood1kgPrice(){ // цена за 1 кг еды
        double result = 0;
        switch (getFoodKind()){
            case UNKNOWN: result = 0;
            break;
            case HAY: result = 20;
            break;
            case CORN: result = 50;
            break;
        }
        return result;
    }

    public double getFoodPrice(){ // информация о цене еды для данного животного
        return calculateFoodWeight() * getFood1kgPrice();
    }

    @Override
    //возвращает результаты сравнения цены еды для данного животного с ценой еды для другого животного
    public int compareFoodPrice(Animal animal) {
        return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
    }

    public FoodKind getFoodKind(){
        return FoodKind.UNKNOWN;
    }

    @Override
    public String toString(){
        return "I am " + getKind() + ", eat " + getFoodKind();
    }

    // метод, который возвращает вес животного
    public double getWeight(){
        return weight;
    }

    // метод, который возвращает коэффициент веса еды к весу тела животного
    public double getFoodCoeff(){
        return 0.02;
    }

    //метод, который рассчитывает необходимый вес еды, по формуле
    // вес-еды = вес-животного * коэффициент веса тела
    public double calculateFoodWeight(){
        return getWeight() * getFoodCoeff();
    }

    // метод, который возвращает информацию о животном в формате:
    //I am <AnimalKind>, eat <FoodKind> <CalculateFoodWeight>
    public String toStringFull(){
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }

    public static void main(String[] args) {
        Duck duck = new Duck(11);
        Hamster hamster = new Hamster(31);
        System.out.println(duck.equals(hamster));
        System.out.println(duck.getFood1kgPrice());
        System.out.println(duck.getClass());
        System.out.println(duck.compareFoodPrice(hamster));
        System.out.println(duck.compareWeight(hamster.getWeight()));
    }
}
