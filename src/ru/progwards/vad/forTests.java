package ru.progwards.vad;

public class forTests {
    static String textGrade(int grade) {
        String str = null;
        if (grade == 0) {
            str = "не оценено";
        }
        if (grade > 0 && grade <= 20) {
            str = "очень плохо";
        }
        if (grade > 20 && grade <= 40) {
            str = "плохо";
        }
        if (grade > 40 && grade <= 60) {
            str = "удовлетворительно";
        }
        if (grade > 60 && grade <= 80) {
            str = "хорошо";
        }
        if (grade > 80 && grade <= 100) {
            str = "отлично";
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(textGrade(80));
    }
}
