package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
    private int passengersNumber;
    private CountDownLatch cdl;
    private Semaphore semaphore;

    public PassengerThread(int passengersNumber, Semaphore semaphore, CountDownLatch cdl) {
        this.passengersNumber = passengersNumber;
        this.semaphore = semaphore;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(passengersNumber + " подходит к кассе ");
            Thread.sleep(500);

            System.out.println(passengersNumber + "покупает билет ");
            semaphore.release();
            Thread.sleep(500);


            System.out.println(passengersNumber + "подходит к автобусу и выбирает место ");
            Thread.sleep(300);
            cdl.countDown();

            System.out.println("Автобус двинется когда заполнится ");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}





