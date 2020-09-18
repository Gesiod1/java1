package ru.progwards.java1.lessons.classes;

public class Hamster extends Animal {
    public Hamster(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind(){
        return animal_hamster;
    }
    @Override
    public FoodKind getFoodKind(){
        return  foodKind_corn;
    }
    @Override
    public double getFoodCoeff(){
        return 0.03;
    }
}
