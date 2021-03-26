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
    private String strStart;
    public Insurance(String strStart, FormatStyle style){
        this.strStart = strStart;
        switch (style){
            case SHORT: DateTimeFormatter.ISO_LOCAL_DATE.format(start);
            case LONG: DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(start);
            case FULL: DateTimeFormatter.ISO_ZONED_DATE_TIME.format(start);
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

    public static void main(String[] args) {
        Instant instant1 = Instant.now();
        ZonedDateTime zdt1 = instant1.atZone(ZoneId.of("Europe/Moscow"));
        Instant instant2 = instant1.plusSeconds(6549849);
        ZonedDateTime zdt2 = instant2.atZone(ZoneId.of("Europe/Moscow"));
        Insurance test = new Insurance(zdt1);
        test.setDuration(zdt2);
        System.out.println();


    }
}
