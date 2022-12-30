package com.solvd.onlineStore.multiThreading;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConsumer extends Thread {
    private DatePool datePool;
    public int number;

    public DateConsumer(DatePool datePool, int number) {
        this.datePool = datePool;
        this.number = number;
    }

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        while (true) {
            try {
                Thread.sleep(500);
                Date date = datePool.getDate();
                System.out.println("Thread " + number + " recived " + simpleDateFormat.format(date));
                Thread.sleep(500);
                datePool.put(date);
                System.out.println("Thread " + number + " return " + simpleDateFormat.format(date));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
