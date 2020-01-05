package com.arya.ds;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		//for matter check this link http://javarevisited.blogspot.in/2014/12/insertion-sort-algorithm-in-java-to-array-example.html

		int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};

		for (int i = 1; i < input.length; i++) {

			for (int j = i; j > 0; j--) {

				if (input[j] < input[j - 1]) {

					int temp = input[j - 1];

					input[j - 1] = input[j];

					input[j] = temp;

				}

			}

			System.out.println("pass " + i + ": "
					+ Arrays.toString(input));
		}

	}
}
