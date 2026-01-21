package org.example.thread;

import org.example.model.Buffer;

public class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(final Buffer buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {


        try {
            while(true) {
                int value = buffer.produce();
                System.out.println(Thread.currentThread().getName() + " produced value: " + value);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
