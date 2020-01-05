package com.arya.ds;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// Worst: O(n2) Avg: O(n log n)
		int[] arr = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
		new QuickSort().sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private void sort(int... arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		quickSort(0, arr.length - 1, arr);
	}

	private void quickSort(int startIndex, int endIndex, int[] arr) {

		int i = startIndex;
		int j = endIndex;
		int pivot = arr[(startIndex + endIndex) / 2];

		while (i <= j) {
			// Find element on left that should be on right
			while (arr[i] < pivot)
				i++;
			// Find element on right that should be on left
			while (arr[j] > pivot)
				j--;

			if (i <= j) {
				swap(i, j, arr);
				i++;
				j--;
			}

		}

		System.out.println("pivot " + pivot);
		System.out.println(Arrays.toString(arr));

		if (startIndex < j)
			quickSort(startIndex, j, arr);// Sort left half
		if (i < endIndex)
			quickSort(i, endIndex, arr);// Sort right half

	}

	private void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
