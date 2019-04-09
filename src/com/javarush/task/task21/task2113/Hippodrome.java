package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run(){
        for (int i = 0; i < 100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            }catch (Exception e){}
        }
    }

    public void move(){
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).move();
        }
    }

    public void print(){
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++){
            System.out.println();
        }

    }

    public Horse getWinner(){
        Horse winner = horses.get(0);
        double max = horses.get(0).getDistance();
        for (int i = 1; i < horses.size(); i++){
            if (horses.get(i).getDistance() > max) {
                max = horses.get(i).getDistance();
                winner = horses.get(i);
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("Flash",3.0,0.0);
        Horse horse2 = new Horse("Star",3.0,0.0);
        Horse horse3 = new Horse("Moon",3.0,0.0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }


}
