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
        int value = num & 0b1111_1111;
        for (int i = 0; i < 8; i++){
            int bit = value & 1; // остаток от деления числа num
            value >>= 1; // число для следующей итерации
            String bitStr = Integer.toString(bit);
            tmp = bitStr + tmp; // добавляем новое значение bit вперед
        }
        return tmp;
    }

    public static void main(String[] args) {
        Binary firstNum = new Binary((byte) -128);
        System.out.println(firstNum);
    }
}
