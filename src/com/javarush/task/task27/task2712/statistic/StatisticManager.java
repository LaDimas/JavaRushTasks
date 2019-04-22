package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;


public class StatisticManager {
    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();
    private StatisticManager() { }

    public static StatisticManager getInstance() { return instance; }

    public void register(EventDataRow data) { statisticStorage.put(data); }

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage;

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        StatisticStorage() {
            storage = new HashMap<>();
            storage.put(EventType.COOKED_ORDER, new ArrayList<>());
            storage.put(EventType.NO_AVAILABLE_VIDEO, new ArrayList<>());
            storage.put(EventType.SELECTED_VIDEOS, new ArrayList<>());
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
    public void register(Cook cook){
        cooks.add(cook);
    }

    public Map<Date, Double> amountPerDay() {
        Map<Date, Double> result = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> eventDataRowList = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        double amount;
        Date date;
        Calendar calendar;
        for (EventDataRow eventDataRow : eventDataRowList) {
            VideoSelectedEventDataRow adVideo = (VideoSelectedEventDataRow) eventDataRow;
            amount = adVideo.getAmount()/100.0;
            calendar = Calendar.getInstance();
            calendar.setTime(adVideo.getDate());
            GregorianCalendar gc = new GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            date = gc.getTime();
            if (result.containsKey(date))
                amount += result.get(date);
            result.put(date, amount);
        }
        return result;
    }


    public Map<Date, Map<String, Integer>> cookLoading() {
        Map<Date, Map<String, Integer>> tempCookingMap = new TreeMap<>();

        List<EventDataRow> tempEventList = statisticStorage.getStorage().get(EventType.COOKED_ORDER);

        for (EventDataRow eventDataRowOne : tempEventList) {
            CookedOrderEventDataRow cookedEvent = (CookedOrderEventDataRow) eventDataRowOne;
            Date date = cookedEvent.getDate();
            Map<String, Integer> cookMap = new TreeMap<>();

            for (EventDataRow eventDataRowTwo : tempEventList) {
                CookedOrderEventDataRow cookedOrderEv = (CookedOrderEventDataRow) eventDataRowTwo;
                String nameOfCook = cookedOrderEv.getCookName();
                int cookTime = cookedOrderEv.getTime();

                if (cookedEvent.getDate() == date) {
                    if (!cookMap.containsKey(nameOfCook)) {
                        cookMap.put(nameOfCook, cookTime/60);
                    } else {
                        int tempTime = cookMap.get(nameOfCook) + eventDataRowTwo.getTime();
                        cookMap.put(nameOfCook, tempTime/60);
                    }
                }
            }

            tempCookingMap.put(date, cookMap);
        }

        return tempCookingMap;
    }

}
//public class StatisticManager {
//    private static StatisticManager ourInstance = new StatisticManager();
//    private StatisticStorage statisticStorage = new StatisticStorage();
//
//    public static StatisticManager getInstance() {
//        return ourInstance;
//    }
//
//    private class StatisticStorage{
//        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();
//
//        public StatisticStorage() {}
//
//        public StatisticStorage(Map<EventType, List<EventDataRow>> storage) {
//            for (EventType eventType : EventType.values()){
//                storage.put(eventType, new ArrayList<>());
//            }
//        }
//
//        private void put(EventDataRow data){
//            storage.get(data.getType()).add(data);
//        }
//
//
//    }
//    private StatisticManager() {
//
//    }
//
//    public void register(EventDataRow data){
//        statisticStorage.put(data);
//    }
//    private Map<EventType, List<EventDataRow>> getData() {
//        return storage;
//    }
//}
