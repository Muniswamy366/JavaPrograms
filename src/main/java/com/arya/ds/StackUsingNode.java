package com.arya.ds;

import java.util.EmptyStackException;

public class StackUsingNode<T> {

	private StackNode<T> top;
	private int size = 0;

	public static void main(String[] args) {
		StackUsingNode<Integer> stack = new StackUsingNode<Integer>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		stack.iterate();
		stack.pop();
		stack.pop();
		stack.iterate();
	}

	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		T item = top.getData();
		top = top.next;
		size--;
		return item;
	}

	public void push(T item) {
		StackNode<T> temp = new StackNode<T>(item);
		temp.next = top;
		top = temp;
		size++;
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}

	private void iterate() {
		StackNode<T> cur = top;
		while (cur.next != null) {
			System.out.print(cur.data + " -> ");
			cur = cur.next;
		}
		System.out.println(cur.data);
	}

	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}
	}

}
