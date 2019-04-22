package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    private StatisticManager statisticManager = StatisticManager.getInstance();

    public void printAdvertisementProfit() {

        Map<Date, Double> advertisementProfit = StatisticManager.getInstance().amountPerDay();
        double totalAmount = 0;
        double amount;
        for (Map.Entry<Date, Double> entry : advertisementProfit.entrySet()) {
            amount = entry.getValue();
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"%1$te-%1$tb-%1$tY - %2$.2f", entry.getKey(), amount));
            totalAmount += amount;
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"Total - %.2f", totalAmount));
    }

//    public void printCookWorkloading() {
//        Map<String, Map<String, Long>> map = StatisticManager.getInstance().getAllCookedOrderEventsData();
//        if(map == null) return;
//        if (map.isEmpty()) return;
//        for (Map.Entry<String, Map<String, Long>> dateEntry : map.entrySet()) {
//            ConsoleHelper.writeMessage(dateEntry.getKey());
//            for (Map.Entry<String, Long> workEntry : dateEntry.getValue().entrySet()) {
//                if (workEntry.getValue() > 0) {
//                    long tmpTime = workEntry.getValue(); // получаем в секундах
//                    if (tmpTime % 60 > 0) tmpTime = tmpTime / 60 + 1; // округляем в большую сторону
//                    else tmpTime = tmpTime / 60;
//                    ConsoleHelper.writeMessage(workEntry.getKey() + " - " + tmpTime + " min");
//                }
//            }
//        }
//    }

    public void printActiveVideoSet() {
        Map<String, Integer> map = StatisticAdvertisementManager.getInstance().active();
        for(Map.Entry entry : map.entrySet()){
            ConsoleHelper.writeMessage(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void printArchivedVideoSet() {
        List<String> list = StatisticAdvertisementManager.getInstance().archive();

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        for(String name : list){
            ConsoleHelper.writeMessage(name);
        }
    }
}
