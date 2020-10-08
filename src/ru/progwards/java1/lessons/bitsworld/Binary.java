package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    byte num;

    public Binary(byte num){
        this.num = num;
    }

    // возвращает двоичное представление числа типа byte, используя только битовые операции
    @Override
    public String toString() {
        String tmp = "";
        while (num > 0){
            int bit = num & 1; // остаток от деления числа num
            num >>= 1; // число для следующей итерации
            String bitStr = Integer.toString(bit);
            tmp = bitStr + tmp; // добавляем новое значение bit вперед
        }
        return tmp;
    }

    public static void main(String[] args) {
        Binary firstNum = new Binary((byte) 127);
        System.out.println(firstNum);
    }
}
