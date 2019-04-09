package com.javarush.task.task21.task2108;

import java.util.Arrays;

/*
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        public Tree clone()throws CloneNotSupportedException{
            String [] newBranches = new String[branches.length];
            for (int i = 0; i < branches.length; i++){
                newBranches[i] = branches[i];
            }
            Tree newTree = new Tree(getName(), newBranches);
            return newTree;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tree tree = (Tree) o;

            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            return Arrays.equals(branches, tree.branches);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(branches);
        }
    }
}
