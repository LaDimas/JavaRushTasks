package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь к файлу архива");
        String address = reader.readLine();
        Path fileZip = Paths.get(address);
        ZipFileManager zipFile = new ZipFileManager(fileZip);
        System.out.println("Введите полный путь к файлу для архивирования");
        String file = reader.readLine();
        Path fileToZip = Paths.get(file);
        zipFile.createZip(fileToZip);
        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
