package ru.progwards.java1.lessons.maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class SalesInfo {
    Map<String, Double> sortProducts = new TreeMap<>(); /* 3.2*/
    /* 3.3*/

    //3.1 - вернуть количество успешно загруженных строк.
    // Если в строке более или менее 4-x полей, или количество и сумма не преобразуются в числа - эту строку не загружаем.
    List<String> list = new ArrayList<>();

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public int loadOrders(String fileName){
        int sucсessfulDownloadLines = 0;
        try (Scanner scanner = new Scanner(new File(fileName))){

            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                String [] lineArray = s.split(",");
                if (lineArray.length == 4 && isNumeric(lineArray[2]) && isNumeric(lineArray[3])){
                    sucсessfulDownloadLines += 1;
                    list.add(s);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sucсessfulDownloadLines;
    }

    //3.2 - вернуть список товаров, отсортированный по наименованию товара.
    // В String - наименование товара, в Double - общая сумма продаж по товару
    public Map<String, Double> getGoods(){
        for (int i = 0; i < list.size(); i++) {
            String [] productInfo = list.get(i).split(", ");
            if (sortProducts.get(productInfo[1]) == null){
                sortProducts.put(productInfo[1], Double.parseDouble(productInfo[3]));
            } else {
                Double oldSum = sortProducts.get(productInfo[1]);
                Double newSum = oldSum + Double.parseDouble(productInfo[3]);
                sortProducts.replace(productInfo[1], oldSum, newSum);
            }
        }
        return sortProducts;
    }

    //3.3 - вернуть список покупателей, отсортированный по алфавиту.
    // В String  - ФИ, в Double - сумма всех покупок покупателя, в Integer - количество покупок
    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() throws  NumberFormatException{
        Map<String, AbstractMap.SimpleEntry<Double, Integer>> sortCostumers = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            String [] productInfo = list.get(i).split(", ");
            if (sortCostumers.get(productInfo[0]) == null){
                sortCostumers.put(productInfo[0], (new AbstractMap.SimpleEntry<>((Double.parseDouble(productInfo[3])),(Integer.parseInt(productInfo[2])))));
            } else {
                AbstractMap.SimpleEntry<Double, Integer> simpleEntry = sortCostumers.get(productInfo[0]);
                Double sum = simpleEntry.getKey();
                Integer count = simpleEntry.getValue();
                sortCostumers.put(productInfo[0], (new AbstractMap.SimpleEntry<>((Double.parseDouble(productInfo[3]) + sum),(Integer.parseInt(productInfo[2])) + count)));
            }
        }
        return sortCostumers;
    }

    public static void main(String[] args) {
        SalesInfo salesInfo = new SalesInfo();
        System.out.println(salesInfo.loadOrders("forRead.txt"));
//        System.out.println(salesInfo.list);
//        System.out.println(salesInfo.getGoods());
        System.out.println(salesInfo.getCustomers());
    }
}
