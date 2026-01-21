package org.example.model;

public class Counter {
    private int count =0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

/**
 *
 * Producer produces the data and puts into a buffer
 * Consumer consumes from same buffer
 *
 * producer will wait once buffer is full
 * consumer will wait if buffer is empty
 * no race condition
 * no busy waiting
 *
 *
 *
 *
 */