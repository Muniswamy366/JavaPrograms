package com.arya.ds;

public class MyQueue {

	private static final int capacity = 3;
	int[] arr = new int[capacity];
	int size = 0;
	int top = -1;
	int rear = 0;

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.pop();
		queue.push(23);
		queue.push(2);
		queue.push(73);
		queue.push(21);
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
	}

	public void push(int pushedElement) {
		if (top < capacity - 1) {
			top++;
			arr[top] = pushedElement;
			System.out.println("Element " + pushedElement + " is pushed to Queue !");
			display();
		} else {
			System.out.println("Overflow !");
		}

	}

	public void pop() {
		if (top >= rear) {
			rear++;
			System.out.println("Pop operation done !");
			display();
		} else {
			System.out.println("Underflow !");
		}
	}

	public void display() {
		if (top >= rear) {
			System.out.println("Elements in Queue : ");
			for (int i = rear; i <= top; i++) {
				System.out.println(arr[i]);
			}
		}
	}

}
