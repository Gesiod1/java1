package ru.progwards.java1.lessons.interfaces;

public class Food implements  CompareWeight{
    private  int weight;
    public Food(int weight){
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public CompareResult compareWeight(double smthHasWeigt) {
        if (this.getWeight() == smthHasWeigt){
            return CompareResult.EQUALS;
        } else if (this.getWeight() < smthHasWeigt){
            return CompareResult.LESS;
        } return CompareResult.GREATER;
    }
}
