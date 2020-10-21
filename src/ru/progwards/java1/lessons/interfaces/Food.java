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
        Food food = (Food) smthHasWeigt;
        if (this.getWeight() == food.getWeight()){
            return CompareResult.EQUAL;
        } else if (this.getWeight() < food.getWeight()){
            return CompareResult.LESS;
        } return CompareResult.GREATER;
    }

//        if (this.getWeight() == smthHasWeigt.getWeight()){
//            return CompareResult.EQUALS;
//        } else if (this.getWeight() < smthHasWeigt.getWeight()){
//            return CompareResult.LESS;
//        } return CompareResult.GREATER;
//    }
    public static void main(String[] args) {
        Food eat1 = new Food(45);
        Food eat2 = new Food(33);
        System.out.println(eat1.compareWeight(eat2));
    }
}
