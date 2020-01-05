package com.arya.advance;

public class PrintingNumberAlphabet1 {

    public static void main(String[] args) {

        Printer1 print = new Printer1();
        Thread t1 = new Thread(new TaskNumAlfa(print, 10, false));
        Thread t2 = new Thread(new TaskNumAlfa(print, 10, true));
        t1.start();
        t2.start();

    }
}

class TaskNumAlfa implements Runnable {

    private int max;
    private Printer1 print;
    private boolean isNumber;

    TaskNumAlfa(Printer1 print, int max, boolean isNumber) {
        this.print = print;
        this.max = max;
        this.isNumber = isNumber;
    }

    @Override
    public void run() {


        if (isNumber) {
            for (int i = 1; i <= 26; i++) {
                print.printNumber(i);
            }

        } else {
            for (int i = 65; i <= 90; i++) {
                print.printAlfabet(i);
            }

        }

    }

}

class Printer1 {

    boolean isOdd = false;

    synchronized void printNumber(int number) {

        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Number    :" + number);
        isOdd = false;
        notifyAll();
    }

    synchronized void printAlfabet(int number) {
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Alfabet   :" + (char) number);
        isOdd = true;
        notifyAll();
    }

}
