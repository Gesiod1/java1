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

    //товары из products, которые имеются во всех магазинах
    public Set<Product> existInAll(){
        // создаем множество из списка всех товаров
        Set<Product> result = new TreeSet<>(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return 0;
            }
        });
        // проходим в цикле по всем магазинам
        for (Shop shop: shops) {
             Set<Product> products = (Set<Product>) shop.getProducts();
             result.retainAll(products);
        }
        return result;
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


    }

}
