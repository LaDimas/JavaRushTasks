package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {

        ArrayList<String> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            list.add(token);
        }
        String [] out = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            out[i] = list.get(i);
        }
        return out;
    }
}
