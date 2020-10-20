package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight {
    public enum CompareResult{
        LESS, EQUALS, GREATER
    }
    public CompareResult compareWeight(CompareWeight smthHasWeigt);
    int getWeight ();
}
