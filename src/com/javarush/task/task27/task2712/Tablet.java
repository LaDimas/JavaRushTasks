package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }



    @Override
    public String toString() {
        return "of Tablet{" +
                "number=" + number +
                '}';
    }

    public void createOrder(){
        Order order = null;

        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            setChanged();
            if (!order.isEmpty())notifyObservers(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e){
            logger.log(Level.INFO, "No video is available for the order " + order.toString());
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
}
