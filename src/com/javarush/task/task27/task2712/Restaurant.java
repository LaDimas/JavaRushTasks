package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) throws Exception{
        Tablet tablet1 = new Tablet(1);
        Waiter waiter = new Waiter();
        Cook cook = new Cook("Amigo");
        tablet1.addObserver(cook);
        cook.addObserver(waiter);
        tablet1.createOrder();
    }
}
