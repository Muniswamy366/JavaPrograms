package com.arya.advance;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(2);

		NumberThread test1 = new NumberThread(semaphore);
		CharThread test2 = new CharThread(semaphore);
		test1.start();
		test2.start();

	}

}

class NumberThread extends Thread {

	Semaphore semaphore;

	public NumberThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {

		try {
			semaphore.acquire();

			for (int i = 1; i <= 26; i++) {

				System.out.println(i);
				Thread.sleep(1000);

				semaphore.release();

			}

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {

		}

	}

}

class CharThread extends Thread {

	Semaphore semaphore;

	public CharThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {

		try {
			semaphore.acquire();

			for (int i = 65; i <= 90; i++) {

				System.out.println((char) i);

				Thread.sleep(1000);
				semaphore.release();

			}

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {

		}

	}

}
