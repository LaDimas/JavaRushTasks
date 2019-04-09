package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 8, 15, 5, 17, 20};
        Integer[] newArray = sort(array);
        for (int i = 0; i < newArray.length; i++){
           System.out.print(newArray[i] + " ");
        }

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        // Calculate median (middle number)
        double median = 0;
        double pos1 = Math.floor((array.length - 1.0) / 2.0);
        double pos2 = Math.ceil((array.length - 1.0) / 2.0);
        if (pos1 == pos2 ) {
            median = array[(int)pos1];
        } else {
            median = (array[(int)pos1] + array[(int)pos2]) / 2.0 ;
        }
        Integer[][] tmp = new Integer[array.length][2];
        Integer [] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            tmp[i][0] = Math.abs(array[i] - (int)median);
            tmp[i][1] = array[i];
        }
        Arrays.sort(tmp, Comparator.comparing(o -> o[0]));

        for (int i = 0; i < tmp.length; i++){
            result[i] = tmp[i][1];
        }
        return result;
    }
}
