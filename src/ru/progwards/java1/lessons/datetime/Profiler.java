package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Profiler
{
    static TreeMap<String, StatisticInfo> tree = new TreeMap<>();

    static List<StackItem> stack = new ArrayList<>();

    public static void enterSection(String name)
    //- войти в профилировочную секцию, замерить время входа.
    {
        stack.add(new StackItem());
    }

    public static void exitSection(String name)
    //- выйти из профилировочной секции.
//        Замерить время выхода, вычислить промежуток времени между входом и выходом в миллисекундах.
    {
//убрать послений из стека
        StackItem si = stack.get(stack.size() - 1);
        si.calcTimes();
        stack.remove(si);

//вычесть из всех  остальных в стеке
        for (int i = stack.size() - 1; i >= 0; i--)
        {
            StackItem cur = stack.get(i);
            cur.selfTime = cur.selfTime - si.selfTime;
        }

//добавить в список
        StatisticInfo statisticInfo = tree.get(name);
        if (statisticInfo == null)
        {
            tree.put(name, StatisticInfo.update(name, si));
        } else
        {
            statisticInfo.fullTime = statisticInfo.fullTime + si.fullTime;
            statisticInfo.selfTime = statisticInfo.selfTime + si.selfTime;
            statisticInfo.count++;
        }
    }

    public static List<StatisticInfo> getStatisticInfo()
    //получить профилировочную статистику, отсортировать по наименованию секции
    {
        List<StatisticInfo> list = new ArrayList<>();
        for (var entry : tree.entrySet())
        {
            list.add(entry.getValue());
        }
        return list;
    }

    public static void main(String[] args) throws InterruptedException
    {
        enterSection("1");
        Thread.sleep(10);

        for (int i = 0; i < 5; i++)
        {

            enterSection("3");
            Thread.sleep(30);

            enterSection("5");
            Thread.sleep(50);
            exitSection("5");

            exitSection("3");

        }

        enterSection("4");
        Thread.sleep(40);
        exitSection("4");

        exitSection("1");

        System.out.println(getStatisticInfo());
    }
}

class StackItem
{
    public int fullTime;// полное время выполнения секции в миллисекундах.
    public int selfTime;// чистое время выполнения секции в миллисекундах.
    public LocalDateTime startTime;

    StackItem()
    {
        selfTime = 0;
        startTime = LocalDateTime.now();
    }

    void calcTimes()
    {
        fullTime = (int) Duration.between(startTime, LocalDateTime.now()).toMillis();
        selfTime = selfTime + fullTime;
    }
}

class StatisticInfo
{
    public String sectionName; // имя секции
    public int fullTime;// полное время выполнения секции в миллисекундах.
    public int selfTime;// чистое время выполнения секции в миллисекундах.
    // Для вложенных секций, из времени выполнения внешней секции нужно вычесть времена
// выполнения вложенных секций.
    public int count;// количество вызовов. В случае, если вызовов более одного, fullTime и selfTime
// содержат суммарное время выполнения всех вызовов.

    static StatisticInfo update(String name, StackItem item)
    {
        StatisticInfo res = new StatisticInfo();
        res.sectionName = name;
        res.fullTime = item.fullTime;
        res.selfTime = item.selfTime;
        res.count = 1;
        return res;
    }

    @Override
    public String toString()
    {
        return "StatisticInfo{" +
                "sectionName='" + sectionName + '\'' +
                ", fullTime=" + fullTime +
                ", selfTime=" + selfTime +
                ", count=" + count +
                '}' + "\n";
    }
}



