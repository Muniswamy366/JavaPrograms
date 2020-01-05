package com.arya.advance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {

	private final BlockingQueue<Object> queue;

	public Producer(BlockingQueue<Object> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {

			try {

				System.out.println("Produced " + i);
				queue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

class Consumer implements Runnable {

	private final BlockingQueue<Object> queue;

	public Consumer(BlockingQueue<Object> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {

		while (true) {
			try {
				System.out.println("Consumed " + queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class ProducerConsumerWithBlockingQueue {

	public static void main(String[] args) {

		BlockingQueue<Object> queue = new LinkedBlockingQueue<Object>();

		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));

		producer.start();
		consumer.start();

	}

}
