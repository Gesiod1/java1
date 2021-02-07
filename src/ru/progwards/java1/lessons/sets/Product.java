package ru.progwards.java1.lessons.sets;

public class Product {
    // уникальный артикул товара
    private String code;
    public Product(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}
