package com.arya.ds;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		//for matter check this link http://javarevisited.blogspot.in/2014/08/bubble-sort-algorithm-in-java-with.html
		// Worst: O(n2) Avg: O(n2)

		int[] input = {32, 39, 21, 45, 23, 3};

		for (int i = 0; i < input.length; i++) {

			for (int j = 1; j < input.length - i; j++) {

				if (input[j - 1] > input[j]) {

					int temp = input[j - 1];

					input[j - 1] = input[j];

					input[j] = temp;

				}

			}

			System.out.println("pass " + (i + 1) + ": " + Arrays.toString(input));
		}

	}
}
