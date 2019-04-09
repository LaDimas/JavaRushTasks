package com.javarush.task.task22.task2201;

public class StringForFirstThreadTooShortException extends RuntimeException {
    public String ex1;


    public StringForFirstThreadTooShortException(String ex1) {
        this.ex1 = ex1;
    }
}
