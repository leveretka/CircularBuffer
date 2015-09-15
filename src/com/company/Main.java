package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CircularBuffer circularBuffer = new CircularBuffer(250);

        List<Producer> producers = new ArrayList<Producer>();
        for (int i = 0; i < 3; ++i) {
            producers.add(new Producer(i, circularBuffer));
        }

        List<Consumer> consumers = new ArrayList<Consumer>();
        for (int i = 0; i < 5; ++i) {
            consumers.add(new Consumer(i, circularBuffer));
        }

        for (Producer p: producers) {
            p.start();
        }

        for (Consumer c: consumers) {
            c.start();
        }

    }
}
