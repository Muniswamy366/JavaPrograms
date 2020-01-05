package com.arya.advance;

public class PrintingNumberAlphabetBest {

    public static void main(String[] args) {
        Printer3 printer = new Printer3(true);
        Thread alf = new Thread(new AlfThread(printer));
        Thread num = new Thread(new NumThread(printer));
        num.start();
        alf.start();
    }
}

class AlfThread implements Runnable {
    Printer3 printer;

    public AlfThread(Printer3 printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        synchronized (printer) {
            for (int i = 65; i <= 90; i++) {
                try {
                    while (printer.flag) {
                        printer.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Alf  :" + (char) i);
                    printer.flag = !printer.flag;
                    printer.notifyAll();
                }
            }
        }
    }
}

class NumThread implements Runnable {
    Printer3 printer;

    public NumThread(Printer3 printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        synchronized (printer) {
            for (int i = 1; i <= 26; i++) {
                try {
                    while (!printer.flag) {
                        printer.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Num :" + i);
                    printer.flag = !printer.flag;
                    printer.notifyAll();
                }
            }
        }
    }
}

class Printer3 {
    public boolean flag = true;

    Printer3(boolean flag) {
        this.flag = flag;
    }

}
