package com.arya.advance;

public class FinalAlphNum1 {

    public static void main(String[] args) {
        int num = 20;
        Printer2 Printer2 = new Printer2(1);

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= num; i = i + 3) {
                Printer2.printThread1(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= num; i = i + 3) {
                Printer2.printThread2(i);
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 3; i <= num; i = i + 3) {
                Printer2.printThread3(i);
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }

}

class Printer2 {
    private int flag = 0;

    public Printer2(int flag) {
        super();
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void printThread1(int num) {
        synchronized (this) {
            while (flag != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Thread 1  : " + num);
            this.setFlag(2);
            this.notifyAll();

        }
    }

    public void printThread2(int num) {
        synchronized (this) {
            while (flag != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Thread 2 : " + num);
            this.setFlag(3);
            this.notifyAll();

        }
    }

    public void printThread3(int num) {
        synchronized (this) {
            while (flag != 3) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Thread 3 : " + num);
            this.setFlag(1);
            this.notifyAll();

        }
    }
}
