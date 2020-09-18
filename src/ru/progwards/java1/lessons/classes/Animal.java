package ru.progwards.java1.lessons.classes;

public class Animal { // сохраняем вес животного
    double weight;
    public Animal(double weight){
        this.weight = weight;
    }
    enum AnimalKind { // вид животного
        ANIMAL, COW, HAMSTER, DUCK
    }
    // Объявляем переменныедля класса Animal
    AnimalKind animal_animal = AnimalKind.ANIMAL;
    AnimalKind animal_сow = AnimalKind.COW;
    AnimalKind animal_hamster = AnimalKind.HAMSTER;
    AnimalKind animal_duck = AnimalKind.DUCK;
    public AnimalKind getKind(){ // функция, возвращает вид животного
        return animal_animal;
    }
    enum FoodKind { // еда живтоного
        UNKNOWN, HAY, CORN
    }
    // Объявляем переменные
    FoodKind foodKind_unknown = FoodKind.UNKNOWN;
    FoodKind foodKind_hay = FoodKind.HAY;
    FoodKind foodKind_corn = FoodKind.CORN;
    public FoodKind getFoodKind(){
        return foodKind_unknown;
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
}
