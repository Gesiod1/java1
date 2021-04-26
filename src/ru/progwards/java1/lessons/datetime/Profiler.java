package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.util.*;

public class Profiler {
    public static List<StatisticInfo> statisticInfo = new ArrayList<>();

    public static void enterSection(String name) {
        Instant instant = Instant.now();

        for (int i = 0; i < statisticInfo.size(); i++) {
            StatisticInfo current = statisticInfo.get(i);
            if (current.sectionName.equals(name)) {
                current.selfTime = instant.toEpochMilli();
                statisticInfo.set(i, current);
                return;
            }
        }

        StatisticInfo stInfo = new StatisticInfo();
        stInfo.sectionName = name;
        stInfo.selfTime = instant.toEpochMilli();;
        statisticInfo.add(stInfo);
    }

    public static void exitSection(String name) {
        Instant instant = Instant.now();

        for (int i = 0; i < statisticInfo.size(); i++) {
            StatisticInfo current = statisticInfo.get(i);
            if (current.sectionName.equals(name)) {
                current.selfTime = instant.toEpochMilli() - current.selfTime;
                current.count++;
                current.fullTime = current.count > 1 ? current.fullTime + current.selfTime : 0;
                statisticInfo.set(i, current);
                break;
            }
        }
    }

    public static List<StatisticInfo> getStatisticInfo() {

        return statisticInfo;
    }

    public static void main(String[] args) {
        long val = 0;
        enterSection("1");
        for (int i = 0; i< 1000000; i++) {
            enterSection("2");
            val += i * 2;
            System.out.println(val + '\n');
            exitSection("2");
        }
        for (int i = 0; i< 10; i++) {
            enterSection("3");
            val += i * 2;
            System.out.println(val + '\n');
            exitSection("3");
        }
        exitSection("1");
        System.out.println(getStatisticInfo().get(0).sectionName + ": " + getStatisticInfo().get(0).selfTime);
        System.out.println(getStatisticInfo().get(1).sectionName + ": " + getStatisticInfo().get(1).selfTime);
        System.out.println(getStatisticInfo().get(1).sectionName + ": " + getStatisticInfo().get(1).fullTime);
        System.out.println(getStatisticInfo().get(2).sectionName + ": " + getStatisticInfo().get(2).selfTime);
        System.out.println(getStatisticInfo().get(2).sectionName + ": " + getStatisticInfo().get(2).fullTime);
        enterSection("4");
        for (int i = 0; i< 10000; i++) {
            val += i * 2;
            System.out.println(val + '\n');
        }
        exitSection("4");
        System.out.println(getStatisticInfo().get(3).sectionName + ": " + getStatisticInfo().get(3).selfTime);
        System.out.println(getStatisticInfo().get(3).sectionName + ": " + getStatisticInfo().get(3).fullTime);
    }
}
    class StatisticInfo {
        public String sectionName;
        public long fullTime = 0;
        public long selfTime = 0;
        public int count = 0;
    }
