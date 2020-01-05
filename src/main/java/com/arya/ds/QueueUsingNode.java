package com.arya.ds;

import java.util.NoSuchElementException;

public class QueueUsingNode<T> {

	private QueueNode<T> first;
	private QueueNode<T> last;
	private int size;

	public static void main(String[] args) {
		QueueUsingNode<Integer> queue = new QueueUsingNode<Integer>();

		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);

		queue.iterate();
		queue.remove();
		queue.iterate();

	}

	public void add(T item) {
		QueueNode<T> temp = new QueueNode<T>(item);
		if (first == null) {
			first = temp;
			last = temp;
		} else {
			last.next = temp;
			last = last.next;
		}
		size++;
	}

	public T remove() {
		if (first == null)
			throw new NoSuchElementException();
		T data = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		size--;
		return data;
	}

	public T peek() {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return size;
	}

	private void iterate() {
		QueueNode<T> cur = first;
		while (cur.next != null) {
			System.out.print(cur.data + " -> ");
			cur = cur.next;
		}
		System.out.println(cur.data);
	}

	private static class QueueNode<T> {

		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}
	}
}
