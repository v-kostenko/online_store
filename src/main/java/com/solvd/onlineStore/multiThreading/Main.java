package com.solvd.onlineStore.multiThreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        DatePool datePool = new DatePool(5);

        for (int i = 0; i < 4; i++) {
            DateConsumer dateConsumer = new DateConsumer(datePool, i);
            dateConsumer.setDaemon(true);
            dateConsumer.start();
        }

        for (int i = 0; i < 3; i++) {
            DateClient dateClient = new DateClient(datePool, i + 10);
            Thread thread = new Thread(dateClient);
            thread.setDaemon(true);
            thread.start();
        }

        Thread.sleep(20000);


    }
}
