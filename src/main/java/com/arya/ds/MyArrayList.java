package com.arya.ds;

import java.util.Arrays;

public class MyArrayList<E> {

	Object[] arr;
	private int defaultSize = 5;
	private int index = 0;
	private int size;

	MyArrayList() {
		arr = new Object[defaultSize];
		this.size = defaultSize;
	}

	MyArrayList(int size) {
		arr = new Object[size];
		this.size = size;
	}

	public static void main(String[] args) {

		MyArrayList<Integer> mal = new MyArrayList<Integer>();
		mal.add(new Integer(2));
		mal.add(new Integer(5));
		mal.add(new Integer(1));
		mal.add(new Integer(23));
		mal.add(new Integer(14));
		for (int i = 0; i < mal.size(); i++) {
			System.out.print(mal.get(i) + " ");
		}
		mal.add(new Integer(29));
		System.out.println("Element at Index 5:" + mal.get(5));
		System.out.println("List size: " + mal.size());
		System.out.println("Removing element at index 2: " + mal.remove(1));
		for (int i = 0; i < mal.size(); i++) {
			System.out.print(mal.get(i) + " ");
		}

	}

	public void add(E obj) {
		if (this.index >= size)
			incrementArrayList();

		arr[index++] = obj;

	}

	public E get(int index) {
		if (index < this.index)
			return (E) arr[index];
		else
			throw new IndexOutOfBoundsException();
	}

	public Object remove(int index) {
		Object obj = arr[index];

		if (index < this.index) {
			int temp = index;

			while (temp < this.index) {
				if (temp == this.index - 1)
					arr[temp++] = null;
				else
					arr[temp] = arr[++temp];
			}

			this.index--;
			return obj;

		} else
			throw new IndexOutOfBoundsException();

	}

	public int size() {
		return this.index;
	}

	private void incrementArrayList() {
		arr = Arrays.copyOf(arr, this.size * 2);
		System.out.println("\nNew length: " + arr.length);
	}
}
