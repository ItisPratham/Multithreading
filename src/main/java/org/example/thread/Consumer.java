package org.example.thread;

import org.example.model.Buffer;

public class Consumer implements Runnable {

    private final Buffer buffer;

    public Consumer(final Buffer buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        try {
            while(true) {
                int value = buffer.consume();
                System.out.println(Thread.currentThread().getName() + "consumed value: " + value);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
