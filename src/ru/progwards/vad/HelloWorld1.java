package ru.progwards.vad;

public class HelloWorld1 {
    static String textGrade(int grade) {
        String str;

        if (grade == 0) {
            str = "не оценено";
        } else {
            if (grade > 0 && grade <= 20) {
                str = "очень плохо";
            } else {
                if (grade > 20 && grade <= 40) {
                    str = "плохо";
                } else {
                    if (grade > 40 && grade <= 60) {
                        str = "удовлетворительно";
                    } else {
                        if (grade > 60 && grade <= 80) {
                            str = "хорошо";
                        } else {
                            if (grade > 80 && grade <= 100) {
                                str = "отлично";
                            } else {
                                str = "не определено";
                            }
                        }
                    }
                }
            }

        }
        return str;
    }

    public static void main(String[] args) {
        textGrade(65);
    }

}
