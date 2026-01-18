package org.example.model;

public class StopWatch {
    private long start;

    public void start() {
        start = System.nanoTime();
    }

    public long elapsedMillis() {
        return (System.nanoTime() - start) / 1_000_000;
    }
}
