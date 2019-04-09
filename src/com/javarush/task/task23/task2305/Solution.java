package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution [] twoSol = new Solution[2];
        for (int i = 0; i < twoSol.length; i++){
            twoSol[i] = new Solution();
            twoSol[i].innerClasses[0] = twoSol[i].new InnerClass();
            twoSol[i].innerClasses[1] = twoSol[i].new InnerClass();
        }
        return twoSol;
    }

    public static void main(String[] args) {

    }
}
