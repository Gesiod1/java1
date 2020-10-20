package ru.progwards.java1.lessons.interfaces;

public class Food implements  CompareWeight{
    private int weight;
    public Food(int weight){
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
//        Food food = (Food) smthHasWeigt;
//        if (this.food() == food.getWeight()){
//            return CompareResult.EQUALS;
//        } else if (this.food() < food.getWeight()){
//            return CompareResult.LESS;
//        } return CompareResult.GREATER;
//    }

        if (this.getWeight() == smthHasWeigt.getWeight()){
            return CompareResult.EQUALS;
        } else if (this.getWeight() < smthHasWeigt.getWeight()){
            return CompareResult.LESS;
        } return CompareResult.GREATER;
    }

    public static void main(String[] args) {

    }
}
