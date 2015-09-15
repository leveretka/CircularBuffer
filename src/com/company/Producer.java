package com.company;

/**
 * Created by margarita on 08.09.15.
 */
public class Producer extends Thread {

    private CircularBuffer circularBuffer;
    private int id;

    public Producer(int id, CircularBuffer circularBuffer) {
        this.id = id;
        this.circularBuffer = circularBuffer;
    }

    public void run() {

        while (true) {
            Object o = new Object();
            circularBuffer.put(o);
            System.out.println("Producer #" + id + " put " + o + ".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
