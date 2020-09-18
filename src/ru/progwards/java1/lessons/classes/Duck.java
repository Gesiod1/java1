package ru.progwards.java1.lessons.classes;

public class Duck extends  Animal{
    public Duck (double weight) {
        super(weight);
    }

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
