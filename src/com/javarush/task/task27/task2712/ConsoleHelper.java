package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString()throws Exception{
        String line = reader.readLine();
        return line;
    }
    public static List<Dish> getAllDishesForOrder()throws Exception{
        List<Dish> list = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Выберите блюдо или \"exit\"");
        String dish = "";
        while (!dish.equalsIgnoreCase("exit")){
            dish = readString();
            if (!dish.equalsIgnoreCase("exit")){
                switch (dish){
                    case "Fish" : list.add(Dish.Fish);
                    break;
                    case "Steak": list.add(Dish.Steak);
                    break;
                    case "Soup" : list.add(Dish.Soup);
                    break;
                    case "Juice" : list.add(Dish.Juice);
                    break;
                    case "Water" : list.add(Dish.Water);
                    break;
                    default      : writeMessage("Такого блюда нет.");
                }
            }
        }
        return list;
    }

}
