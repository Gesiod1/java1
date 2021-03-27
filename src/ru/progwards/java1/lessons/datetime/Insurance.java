package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Insurance {
    //дата-время начала действия страховки
    private ZonedDateTime start;
    //продолжительность действия
    private Duration duration;

    //стили формата даты-времени
    public static enum FormatStyle {SHORT, LONG, FULL}

    //Реализовать конструкторы:
    //установить дату-время начала действия страховки
    public Insurance(ZonedDateTime start){
        this.start = start;
    }

    //установить дату-время начала действия страховки
//    SHORT соответствует ISO_LOCAL_DATE
//    LONG  - ISO_LOCAL_DATE_TIME
//    FULL - ISO_ZONED_DATE_TIME

    public Insurance(String strStart, FormatStyle style){

        switch (style){
            case SHORT:
                Instant instant1 = Instant.from((DateTimeFormatter.ISO_LOCAL_DATE.parse(strStart)));
                start = instant1.atZone(ZoneId.systemDefault());
                break;
            case LONG:
                Instant instant2 = Instant.from((DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(strStart)));
                start = instant2.atZone(ZoneId.systemDefault());
                break;
            case FULL:
                Instant instant3 = Instant.from((DateTimeFormatter.ISO_ZONED_DATE_TIME.parse(strStart)));
                start = instant3.atZone(ZoneId.systemDefault());
                break;
        }
    }
    //Для вариантов, когда не задан явно часовой пояс использовать таковой по умолчанию.

    //1.3 Реализовать методы, устанавливающие продолжительность действия страховки:
    //установить продолжительность действия страховки
    public void setDuration(Duration duration){
        this.duration = duration;
    }

    //1.4 установить продолжительность действия страховки, задав дату-время окончания
    public void setDuration(ZonedDateTime expiration){
        this.duration = Duration.between(start, expiration);
    }
    //1.5 -  установить продолжительность действия страховки, задав целыми числами количество месяцев, дней и часов
    public void setDuration(int months, int days, int hours){}

    //1.6 - установить продолжительность действия страховки
    public void setDuration(String strDuration, FormatStyle style){}

    public ZonedDateTime getStart() {
        return start;
    }

    public Duration getDuration() {
        return duration;
    }

    public static void main(String[] args) {
        Instant instant1 = Instant.now();
        ZonedDateTime zdt1 = instant1.atZone(ZoneId.of("Europe/Moscow"));
        Instant instant2 = instant1.plusSeconds(180);
        ZonedDateTime zdt2 = instant2.atZone(ZoneId.of("Europe/Moscow"));
        System.out.println(zdt1.toString());
        Insurance test = new Insurance(zdt1);
        test.setDuration(zdt2);
        System.out.println( test.getDuration().toMillis());
        System.out.println();


    }
}
