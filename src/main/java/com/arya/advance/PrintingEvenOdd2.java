package com.arya.advance;

public class PrintingEvenOdd2 {

    static boolean turn = false;// false is even and true is odd

    public static void main(String[] args) {
        Object o = new Object();
        Thread tEven = new Thread(new EvenThread(o));
        Thread tOdd = new Thread(new OddThread(o));
        tEven.start();
        tOdd.start();
    }

    static class OddThread implements Runnable {
        Object o;

        public OddThread(Object o) {
            this.o = o;
        }

        @Override
        public void run() {
            synchronized (o) {
                for (int i = 1; i <= 50; i = i + 2) {
                    try {
                        while (!turn) {
                            o.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("Even :" + i);
                        turn = !turn;
                        o.notifyAll();
                    }
                }
            }
        }
    }

    static class EvenThread implements Runnable {
        Object o;

        public EvenThread(Object o) {
            this.o = o;
        }

        @Override
        public void run() {
            synchronized (o) {
                for (int i = 0; i <= 50; i = i + 2) {
                    try {
                        while (turn) {
                            o.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("Odd  :" + i);
                        turn = !turn;
                        o.notifyAll();
                    }
                }
            }
        }
    }
}
