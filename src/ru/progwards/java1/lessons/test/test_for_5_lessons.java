package ru.progwards.java1.lessons.test;

public class test_for_5_lessons {
        private String name;
        private int age;
        private String country;
        //конструктор по умолчанию, устанавливающий country = "RU"
        test_for_5_lessons  (){
            this.country = "RU";
        }
        /*
        конструктор с параметрами String name, int age, вызывающий конструктор по умолчанию,
        и устанавливающий значения переменным name и age из соответствующих параметров
        */
        test_for_5_lessons  (String name, int age){
            this();
            this.name = name;
            this.age = age;
        }
        /* публичные функции String getName(), int getAge(), String getCountry(),
        возвращающие значения соответствующих переменных
        */
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public String getCountry(){
            return country;
        }

    public static void main(String[] args) {
            test_for_5_lessons lolik = new test_for_5_lessons("Vadim", 28);
        System.out.println(lolik.getCountry());
    }

}
