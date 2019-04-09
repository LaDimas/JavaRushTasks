package com.javarush.task.task25.task2512;


import java.util.ArrayDeque;
import java.util.Deque;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    private Deque<Throwable> stack = new ArrayDeque<>();
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Throwable throwable = e;
        while (throwable != null){
            stack.add(throwable);
            throwable = throwable.getCause();
        }
        while(!stack.isEmpty()){
            System.out.println(stack.removeLast());
        }
}


    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
