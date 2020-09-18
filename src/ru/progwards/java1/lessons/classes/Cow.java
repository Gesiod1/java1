package ru.progwards.java1.lessons.classes;

public class Cow extends Animal {
    public Cow(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind(){
        return animal_сow;
    }
    @Override
    public FoodKind getFoodKind(){
        return  foodKind_hay;
    }
    @Override
    public double getFoodCoeff(){
        return 0.005;
    }
}
