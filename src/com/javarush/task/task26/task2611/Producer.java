package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{

    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 1;
        try {
            while (true){
                String key = "" + i;
                map.putIfAbsent(key, "Some text for " + key);
                i++;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
        System.out.println("[THREAD_NAME] thread was terminated");
    }
    }
}
