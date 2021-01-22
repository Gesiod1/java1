package ru.progwards.java1.lessons.collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T>  {
    private T[] array;

    ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
         return Arrays.stream(this.array).iterator().hasNext();
    }

    @Override
    public T next() {
        return Arrays.stream(this.array).iterator().next();
    }

}
