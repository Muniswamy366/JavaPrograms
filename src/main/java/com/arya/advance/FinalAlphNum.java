package com.arya.advance;

public class FinalAlphNum {

	public static void main(String[] args) {

		PrintEvenOdd printEvenOdd = new PrintEvenOdd();
		Thread t1 = new Thread(new PrintOdd(printEvenOdd, 20));
		Thread t2 = new Thread(new PrintEven(printEvenOdd, 20));

		t1.start();
		t2.start();
	}

}

class PrintOdd implements Runnable {
	private PrintEvenOdd printEvenOdd;
	private int size;

	/**
	 * @param printEvenOdd
	 */
	public PrintOdd(PrintEvenOdd printEvenOdd, int size) {
		super();
		this.printEvenOdd = printEvenOdd;
		this.size = size;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 1; i <= size; i = i + 2) {
			printEvenOdd.printOdd(i);
		}
	}

}

class PrintEven implements Runnable {
	private PrintEvenOdd printEvenOdd;
	private int size;

	/**
	 * @param printEvenOdd
	 */
	public PrintEven(PrintEvenOdd printEvenOdd, int size) {
		super();
		this.printEvenOdd = printEvenOdd;
		this.size = size;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 2; i <= size; i = i + 2) {
			printEvenOdd.printEven(i);
		}
	}

}

class PrintEvenOdd {
	private boolean flag = false;

	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void printEven(int i) {
		synchronized (this) {
			while (!this.isFlag()) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Even : " + i);
			this.setFlag(false);
			this.notifyAll();
		}
	}

	public void printOdd(int i) {
		synchronized (this) {
			while (this.isFlag()) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Odd  : " + i);
			this.setFlag(true);
			this.notifyAll();
		}
	}

}
