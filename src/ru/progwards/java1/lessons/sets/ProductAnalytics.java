package ru.progwards.java1.lessons.sets;

import java.util.*;

public class ProductAnalytics {
    //список магазинов
    private List<Shop> shops;
    //список всех имеющихся в ассортименте товаров.
    // Все товары, присутствующие в магазинах, обязательно присутствуют в products,
    // но так же тут могут быть и товары, которых нет в магазинах
    private List<Product> products;

    public ProductAnalytics(List<Shop> shops, List<Product> products) {
        this.shops = shops;
        this.products = products;
    }

    //2.13 - товары из products, которые имеются во всех магазинах
    public Set<Product> existInAll(){
        Set<Product> result = new HashSet<>(products);
        for (Shop shop: shops) {
             Set<Product> products = (Set<Product>) shop.getProducts();
             result.retainAll(products);
        }
        return result;
    }

    //2.14 - товары из products, которые имеются хотя бы в одном магазине
    public Set<Product> existAtListInOne(){
        Set<Product> result = new HashSet<>();
        for (Shop shop: shops) {
            Set<Product> allProducts = new HashSet<>(products);
            Set<Product> products = (Set<Product>) shop.getProducts();
            allProducts.retainAll(products);
            result.addAll(allProducts);
        }
        return  result;
    }

    public static void main(String[] args) {
        List<Product> allProducts = new ArrayList<>();
        for(Integer i = 0; i < 20; i++) {
            allProducts.add(new Product(i.toString()));
        }
        List<Shop> allShops = new ArrayList<>();
        for(Integer i = 0; i < 5; i++) {
            List<Product> products = new ArrayList<>();
            for (Integer j = i; j < i + 4; j++) {
                products.add(allProducts.get(j));
            }
            allShops.add(new Shop(products));
        }
        ProductAnalytics productAnalytics = new ProductAnalytics(allShops, allProducts);
        System.out.println(productAnalytics.existInAll());
        System.out.println(productAnalytics.existAtListInOne());


    }

}
