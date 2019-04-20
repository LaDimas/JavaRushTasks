package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StatisticManager {
    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private StatisticManager() { }

    public static StatisticManager getInstance() { return instance; }

    public void register(EventDataRow data) { statisticStorage.put(data); }

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage;

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
