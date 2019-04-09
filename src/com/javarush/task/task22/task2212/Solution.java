package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        String pattern = "\\+?\\d{0,2}\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{2}[-.\\s]?\\d{2}";

        // Создание Pattern объекта
        Pattern r = Pattern.compile(pattern);

        // Создание matcher объекта
        Matcher m = r.matcher(telNumber);
        if (m.find()) return true;
        else return false;
    }

    public static void main(String[] args) {

    }
}
