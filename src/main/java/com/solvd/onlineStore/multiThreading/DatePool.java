package com.solvd.onlineStore.multiThreading;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class DatePool {

    private int size;
    private int usedDate;
    private BlockingQueue<Date> dates = new ArrayBlockingQueue<>(5);

    public DatePool(int size) {
        this.size = size;
        Date date1 = new Date(2000 - 1900, 10, 10);
        Date date2 = new Date(2000 - 1900, 11, 11);
        dates.add(date1);
        dates.add(date2);
    }

    public synchronized Date getDate() {
        if (usedDate == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        usedDate++;
        notifyAll();
        if (dates.isEmpty()) {
            return new Date();
        }
        try {
            return dates.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void put(Date date) {
        try {
            dates.put(date);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        usedDate--;
        notifyAll();
    }




}
