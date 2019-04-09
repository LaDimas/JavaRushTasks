package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        String [] words = string.split(" ");
        if (words.length < 5) throw new TooShortStringException();
        String line = "";
        for (int i = 1; i < 5; i++){
        line += words[i] + " ";
        }
        return line.trim();
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
