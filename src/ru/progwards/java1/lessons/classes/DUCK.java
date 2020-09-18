package ru.progwards.java1.lessons.classes;

public class DUCK extends  Animal{
    @Override
    public AnimalKind getKind(){
        return animal_duck;
    }
    @Override
    public FoodKind getFoodKind(){
        return  foodKind_corn;
    }
    @Override
    public double getFoodCoeff(){
        return 0.04;
    }
}
