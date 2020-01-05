package com.arya.advance;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerSolutionUsingLock {

    public static void main(String[] args) {

        // Object on which producer and consumer thread will operate
        ProducerConsumerImpl sharedObject = new ProducerConsumerImpl();

        // creating producer and consumer threads
        Producer2 p = new Producer2(sharedObject);
        Consumer2 c = new Consumer2(sharedObject);

        // starting producer and consumer threads
        p.start();
        c.start();
    }

}

class ProducerConsumerImpl {
    // producer consumer problem data
    private static final int CAPACITY = 5;
    private final Queue<Integer> queue = new LinkedList<Integer>();
    private final Random theRandom = new Random();

    // lock and condition variables
    private final Lock aLock = new ReentrantLock();
    private final Condition bufferEmpty = aLock.newCondition();
    private final Condition bufferFull = aLock.newCondition();

    public void put() throws InterruptedException {
        aLock.lock();
        try {
            while (queue.size() == CAPACITY) {
                System.out.println(Thread.currentThread().getName() + " : Buffer is full, waiting");
                bufferFull.await();
            }

            int number = theRandom.nextInt();
            boolean isAdded = queue.offer(number);
            if (isAdded) {
                System.out.printf("%s added %d into queue %n", Thread.currentThread().getName(), number);

                // signal consumer thread that, buffer has element now
                //System.out.println(Thread.currentThread().getName() + " : Signalling that buffer is no more empty now");
                bufferEmpty.signalAll();
            }
        } finally {
            aLock.unlock();
        }
    }

    public void get() throws InterruptedException {
        aLock.lock();
        try {
            while (queue.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " : Buffer is empty, waiting");
                bufferEmpty.await();
            }

            Integer value = queue.poll();
            if (value != null) {
                System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(), value);

                // signal producer thread that, buffer may be empty now
                //System.out.println(Thread.currentThread().getName() + " : Signalling that buffer may be empty now");
                bufferFull.signalAll();
            }

        } finally {
            aLock.unlock();
        }
    }
}

class Producer2 extends Thread {
    ProducerConsumerImpl pc;

    public Producer2(ProducerConsumerImpl sharedObject) {
        super("PRODUCER");
        this.pc = sharedObject;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++)
                pc.put();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer2 extends Thread {
    ProducerConsumerImpl pc;

    public Consumer2(ProducerConsumerImpl sharedObject) {
        super("CONSUMER");
        this.pc = sharedObject;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++)
                pc.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}