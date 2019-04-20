package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    public final List<Advertisement> videos = new ArrayList<>();
    private static AdvertisementStorage storage;

    public static AdvertisementStorage getInstance() {
        if (storage == null) {
            storage = new AdvertisementStorage();
        }
        return storage;
    }


    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 1, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 1, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 1, 10 * 60)); //10 min
    }
    public List<Advertisement> list(){
        return videos;
    }
    public void add(Advertisement advertisement){
        videos.add(advertisement);

    }
}
