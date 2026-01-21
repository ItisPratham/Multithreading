package org.example;

import org.example.model.Buffer;
import org.example.thread.Consumer;
import org.example.thread.Producer;

public class ProducerConsumer {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(100);
        //Buffer buffer2 = new Buffer(100);
        Thread[] producers = new Thread[5];
        Thread[] consumers = new Thread[15];

        for(int i=0;i<5;i++) {
            producers[i] = new Thread(new Producer(buffer));
        }
        for(int i=0;i<13;i++) {
            consumers[i] = new Thread(new Consumer(buffer));
        }
        for(int i=0;i<5;i++) {
            producers[i].start();
        }
        for(int i=0;i<13;i++) {
            consumers[i].start();
        }

//        consumer.start();
//        producer.start();

    }
}
