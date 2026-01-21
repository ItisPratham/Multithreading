package org.example.model;

public class Buffer {

    private final int[] buffer;

    int produceIndex =0;
    int consumeIndex =0;
    int count = 0;

    int value =1;



    public Buffer(int size) {
        buffer = new int[size];
    }


    public synchronized int produce() throws InterruptedException {
        while(count == buffer.length) {
            wait();
        }
        buffer[produceIndex] = value;
        value++;
        produceIndex = (produceIndex+1)% buffer.length;
        count++;

        notifyAll();
        return value-1;
    }

    public synchronized int consume() throws InterruptedException {
        while(count==0) {
            wait();
        }

        int value = buffer[consumeIndex];
        consumeIndex = (consumeIndex+1)% buffer.length;
        count--;

        notifyAll();
        return value;
    }




}
