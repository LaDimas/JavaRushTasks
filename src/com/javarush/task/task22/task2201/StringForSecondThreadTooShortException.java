package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public String ex2;


    public StringForSecondThreadTooShortException(String ex2) {
        this.ex2 = ex2;

    }
}
