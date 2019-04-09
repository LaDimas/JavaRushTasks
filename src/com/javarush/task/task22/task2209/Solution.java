package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
        public static int j;
        public static StringBuilder sb = null;
        public static String [] word = null;
        public static int max = 0;
        public static ArrayList<String> trackList;
        public static ArrayList<String> resultList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        String fileLine = "";
        while (reader1.ready()){
            fileLine += reader1.readLine();
        }
        fileLine.replaceAll("\\p{Punct}|\\n", " ");
        StringBuilder result = getLine(fileLine);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        String wordsLine ="";
        if (words.length == 0) return new StringBuilder();
        for (int i = 0; i< words.length; i++){
            wordsLine += words[i];
        }
        word = wordsLine.split(" +");
        String outLine = "";
        List<StringBuilder> list = new ArrayList<>();
        sb = new StringBuilder(outLine);
        word = wordsLine.split(" +");
        for (j = 0; j < word.length; j++){
            trackList = new ArrayList<>();
            trackList.add(word[j]);
            superCheck(word, word[j]);
        }
        for (int i = 0; i < resultList.size(); i++) {
             {
                 sb.append(resultList.get(i));
                 sb.append(" ");
            }
        }

        for (int i = 1; i < word.length; i++) {
            if (!sb.toString().contains(word[i])) {
                sb.append(word[i]);
                sb.append(" ");
            }
        }
        list.add(0, sb);
        return list.get(0);
        }

        public static void superCheck(String[] word, String preWord){
            ArrayList<String> siutWords = getSiutableWords(word,preWord);
            if (siutWords.size() > 0){
                for (String siut : siutWords) {
                    trackList.add(siut);
                    superCheck(word, siut);
                    trackList.remove(siut);
                }
            }else {
                if (trackList.size() > max){
                    max = trackList.size();
                    resultList.clear();
                    resultList.addAll(trackList);
                }
            }
    }

    public static ArrayList<String> getSiutableWords(String[] word, String baseWord) {
        ArrayList<String> out = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            if (!word[i].equals(baseWord) && !trackList.contains(word[i])) {
                String begin = word[i].substring(0, 1);
                String end = baseWord.substring(baseWord.length() - 1);
                if (begin.equalsIgnoreCase(end)) {
                    out.add(word[i]);
                }
            }
        }
        return out;
    }
}