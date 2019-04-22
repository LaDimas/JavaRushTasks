package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) throws Exception{
        Waiter waiter = new Waiter();
        Cook cook = new Cook("Amigo");
        cook.addObserver(waiter);
        Tablet tablet1 = new Tablet(1);
        tablet1.addObserver(cook);
        tablet1.createOrder();
        DirectorTablet tablet = new DirectorTablet();
        tablet.printAdvertisementProfit();
  //      tablet.printCookWorkloading();
    }
}
