package org.example;

import org.example.model.Account;
import org.example.model.Counter;
import org.example.model.StopWatch;
import org.example.thread.MyThread1;
import org.example.thread.MyThread2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
//        Account account = new Account(100);
//        Thread t1 = new MyThread1(account);
//        Thread t2 = new Thread(new MyThread2(account));
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
        Counter c = new Counter();

//        Thread t1 = new Thread(() -> {
//            for(int i=0;i<10000;i++) {
//                c.increment();
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for(int i=0;i<10000;i++) {
//                c.increment();
//            }
//        });

        List<Thread> threadList = new ArrayList<>();

        for(int i=0;i<500;i++) {
            threadList.add(new Thread(() -> {
                for(int j=0;j<1000000;j++) {
                    c.increment();
                }
            }));
        }
        StopWatch sw = new StopWatch();
        sw.start();

        threadList.forEach(Thread::start);
        threadList.forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        //for(int i=0;i<10;i++);

        System.out.println("Elapsed time: " + sw.elapsedMillis() + " ms");
        System.out.println(c.getCount());



    }
}

//NEW -> RUNNABLE -> RUNNING -> BLOCKING/WAITING -> TERMINATED

//what are shared among threads
//-> static variable
//-> heap objects
//-> instance variable
////what are not shared among threads
//-> thread stack
//-> local variable
//-> call frames