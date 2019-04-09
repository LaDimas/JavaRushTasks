package com.javarush.task.task22.task2211;

import java.io.*;

import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileIn = args[0];
        String fileOut = args[1];
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        FileInputStream inputStream = new FileInputStream(fileIn);
        FileOutputStream outputStream = new FileOutputStream(fileOut);
        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.available()> 0){
            String s = new String(buffer, windows1251);
            buffer = s.getBytes(utf8);
            outputStream.write(buffer);
        }
        inputStream.close();
        outputStream.close();
    }
}
