package com.arya.advance;

import java.util.ArrayList;
import java.util.List;

class Producer1 implements Runnable {

	private final List<Object> queue;

	private final int SIZE;

	public Producer1(List<Object> queue, int SIZE) {
		super();
		this.queue = queue;
		this.SIZE = SIZE;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			synchronized (queue) {
				try {
					// wait if queue is full
					while (queue.size() == SIZE) {
						System.out.println("Queue is full....");
						queue.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("Produced " + i);
					queue.add(i);
					queue.notifyAll();
				}
			}

		}

	}
}

class Consumer1 implements Runnable {

	private final List<Object> queue;

	private final int SIZE;

	public Consumer1(List<Object> queue, int SIZE) {
		super();
		this.queue = queue;
		this.SIZE = SIZE;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (queue) {
				try {
					while (queue.isEmpty()) {
						System.out.println("Queue is empty...");
						queue.wait();
					}
					System.out.println("Consumed " + queue.get(0));
					queue.remove(0);
					queue.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}

public class ProducerConsumerWithVector {

	public static void main(String[] args) {

		List<Object> queue = new ArrayList<Object>();

		Thread producer = new Thread(new Producer1(queue, 5));
		Thread consumer = new Thread(new Consumer1(queue, 5));

		producer.start();
		consumer.start();

	}
}
