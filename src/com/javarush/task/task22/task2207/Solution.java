package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
    public static String [] words;
    public static void main(String[] args) throws Exception{
        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        String sFile = "";
        while (reader1.ready()) {
            sFile += reader1.readLine()+ " ";

        }
        sFile = sFile.replaceAll("\\p{Punct}|\\n", " ");
        sFile = sFile.replaceAll("\\uFEFF", "");
        words = sFile.split(" ");
        for (int i = 0; i < words.length; i++){
            StringBuilder reversWord = new StringBuilder(words[i]);
            reversWord = reversWord.reverse();
            String s1 = reversWord.toString();
            for (int j = i + 1; j < words.length; j++){
                if (words[j].equals(s1)){
                    Pair newPair = new Pair();
                    newPair.first = words[i];
                    newPair.second = s1;
                    if (!result.contains(newPair))
                        result.add(newPair);
                }
            }
        }
        for (Pair pair : result){
            System.out.println(pair.first + " " + pair.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
