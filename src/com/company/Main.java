package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch (100);
        Semaphore sem = new Semaphore (4);
        for (int i = 1; i <= cdl.getCount (); i++) {
            new PassengerThread(i, sem, cdl) .start();
        }
        try {
            cdl.await();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("______________________________________");
        System.out.println("Мы получили уведомление, о том что все пассажиры купили билеты и готовы к выезду. "
                + " Желаем доброго пути !");

    }
}
