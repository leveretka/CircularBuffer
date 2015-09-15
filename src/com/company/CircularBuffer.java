package com.company;

/**
 * Created by margarita on 08.09.15.
 */
public class CircularBuffer {

    private Object[] buffer;
    private int write;
    private int read;
    private int count;

    public CircularBuffer(int n) {
        this.buffer = new Object[n];
        this.write = 0;
        this.read = 0;
        this.count = 0;
    }

    public void put(Object o) {
        synchronized (buffer) {
            while (count >= buffer.length) {
                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer[write++] = o;
            count++;
            write %= buffer.length;
            buffer.notifyAll();
        }
    }

    public Object get() {
        Object o;
        synchronized (buffer) {
            while (count <= 0) {
                try {
                    buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            o = buffer[read++];
            count--;
            read %= buffer.length;
            buffer.notifyAll();
        }
        return o;
    }
}
