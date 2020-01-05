package com.arya.ds;

import java.util.Arrays;

public class TwoStacksSingleArray {

	int size;
	int top1;
	int top2;
	int[] arr;

	TwoStacksSingleArray(int size) {
		this.size = size;
		arr = new int[size];
		top1 = -1;
		top2 = size;
	}

	public static void main(String[] args) {
		TwoStacksSingleArray stack = new TwoStacksSingleArray(10);

		stack.push1(10);
		stack.push1(20);
		// stack.push1(30);
		// stack.push1(40);
		// stack.push1(50);
		// stack.push1(60);
		// stack.push1(70);
		// stack.push1(80);
		// stack.push1(110);

		stack.push2(100);
		stack.push2(90);

		System.out.println(stack.pop1());
		stack.pop1();

		System.out.println(Arrays.toString(stack.arr));
	}

	public void push1(int element) {
		if (top1 < top2 - 1)
			arr[++top1] = element;
		else
			throw new StackOverflowError("stack is full");
	}

	public void push2(int element) {
		if (top1 < top2 - 1)
			arr[--top2] = element;
		else
			throw new StackOverflowError("stack is full");
	}

	public int pop1() {
		if (top1 >= 0)
			return arr[top1--];
		else
			throw new RuntimeException("stack is empty");
	}

	public int pop2() {
		if (top1 < size)
			return arr[top2++];
		else
			throw new RuntimeException("stack is empty");
	}
}
