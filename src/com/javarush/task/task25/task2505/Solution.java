package com.javarush.task.task25.task2505;

import java.util.logging.Level;
import java.util.logging.Logger;


/*
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//            setDaemon(true);
        }

        @Override
        public void run() {
            try {
                throw new NullPointerException("it's an example");
            }catch (NullPointerException e){
                Logger.getLogger(Class.class.getName()).log(Level.ALL,e.getMessage());
                throw new NullPointerException("it's an example");
            }



        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread t, Throwable e){
                try {
                    Thread.sleep(500);
                    System.out.println(String.format("%s, %s, %s",secretKey, t.getName(), e.getMessage()));
                }catch (Exception ex){
                    System.out.println(ex);
                }
            }
        }
    }

}

