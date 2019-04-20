package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.util.List;



public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws Exception{
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public int getTotalCookingTime(){
        int total = 0;
        for (Dish dish : dishes){
            total += dish.getDuration();
        }
        return total;
    }
    public boolean isEmpty(){
        return dishes.isEmpty();
    }
    @Override
    public String toString() {
        String order = "";
        StringBuilder sb = new StringBuilder(order);
        if (!dishes.isEmpty()){
            sb.append("Your order:");
            sb.append(dishes.toString());
            sb.append(tablet);
        }
        return sb.toString();

    }
}
