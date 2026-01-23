package org.example;

import org.example.thread.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerWIthThreadSafeDs {



    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(100);

        Runnable producer = () -> {
            int value =0;
            try {
                while(true) {
                    buffer.put(value);
                    System.out.println("Produced " + value);
                    value++;
                    Thread.sleep(200);
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            int value =0;
            try {
                while(true) {
                    value = buffer.take();
                    System.out.println("consumed " + value);
                    Thread.sleep(500);
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();




    }

}
