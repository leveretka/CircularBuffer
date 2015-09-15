package com.company;

/**
 * Created by margarita on 08.09.15.
 */
public class Consumer extends Thread {

    private CircularBuffer circularBuffer;
    private int id;

    public Consumer(int id, CircularBuffer circularBuffer) {
        this.id = id;
        this.circularBuffer = circularBuffer;
    }

    public void run() {

        while (true) {
            System.out.println("Consumer #" + id + " got " + circularBuffer.get() + ".");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
