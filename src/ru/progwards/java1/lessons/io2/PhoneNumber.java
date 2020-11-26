package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    public static String format(String phone){
        StringBuilder stringBuilder = new StringBuilder();
        // убираем все лишнее кроме цифр
        for (char c : phone.toCharArray())
            {if (Character.isDigit(c))
            stringBuilder.append(c);
            }
        phone = stringBuilder.toString();
        // если длина номера не 10 или 11 цифр, то пробрасываем исключение
        if ((phone.length() != 11) && (phone.length()  != 10)){
            throw new IndexOutOfBoundsException();
        }
        // если длина 11 цифр, то убираем первую получив подстроку со второй цифры
        if (phone.length() == 11){
            phone = phone.substring(1);
            }
        StringBuilder formatPhone = new StringBuilder();
        formatPhone.append("+7(");
        formatPhone.append(phone.substring(0, 3));
        formatPhone.append(")");
        formatPhone.append(phone.substring(3, 6));
        formatPhone.append("-");
        formatPhone.append(phone.substring(6));
        String result = formatPhone.toString();
        return result;
        }

    public static void main(String[] args) {
        String test = "+80345h8jh7mmf45v*8*1";
        System.out.println(format(test));
    }
    }

