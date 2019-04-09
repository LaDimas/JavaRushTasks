package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread loggingStateThread;

    @Override
    public void run() {
        State state, lastState = null;
        while (loggingStateThread.getState()!= State.TERMINATED){
            state = loggingStateThread.getState();
            if (state != lastState) {
                System.out.println(state);
                lastState = state;
            }
        }
    }

    public LoggingStateThread(Thread thread) {
        loggingStateThread = thread;
    }
}
