package com.arya.ds;

import java.util.Arrays;


public class SelectionSort {

	public static void main(String[] args) {

		//for info read this http://www.java2novice.com/java-sorting-algorithms/selection-sort/

		int[] arr = {5, 1, 12, -5, 16, 2, 12, 14};

		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[index])
					index = j;

			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;

			System.out.println("pass " + (i + 1) + " " + Arrays.toString(arr));
		}


	}
}
