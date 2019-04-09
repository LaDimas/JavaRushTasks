package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            if (i != a.i) return false;
            return j == a.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A)super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            CloneNotSupportedException exception = new CloneNotSupportedException();
            if (this.getClass()== B.class)throw exception;
            return (B)super.clone();
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            return (C)super.clone();
        }
    }

    public static void main(String[] args)throws Exception {
        C c = new C(13, 15, "Class C");
        C c1 = c.clone();
        System.out.println(c.equals(c1));
        A a = new A(21, 22);
        A a1 = a.clone();
        System.out.println(a.equals(a1));
        B b = new B(213, 215, "Class B");
        B b1 = b.clone();
        System.out.println(b.equals(b1));
    }
}
