package com.arya.ds;

public class MyStack<E> {

	private int stackSize;
	private Object[] stackArr;
	private int top;

	public MyStack(int size) {
		this.stackSize = size;
		this.stackArr = new Object[stackSize];
		this.top = -1;
	}

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>(5);
		try {
			stack.push(4);
			stack.push(8);
			stack.push(3);
			stack.push(89);
			stack.pop();
			stack.push(34);
			stack.push(45);
			stack.push(78);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void push(E entry) throws Exception {
		if (this.isStackFull()) {
			throw new Exception("Stack is already full. Can not add element.");
		}
		System.out.println("Adding: " + entry);
		this.stackArr[++top] = entry;
	}

	public E pop() throws Exception {
		if (this.isStackEmpty()) {
			throw new Exception("Stack is empty. Can not remove element.");
		}
		E entry = (E) this.stackArr[top--];
		System.out.println("Removed entry: " + entry);
		return entry;
	}

	public E peek() {// returning top element in the stack with out removing.
		return (E) stackArr[top];
	}

	public boolean isStackEmpty() {
		return (top == -1);
	}

	public boolean isStackFull() {
		return (top == stackSize - 1);
	}

}
