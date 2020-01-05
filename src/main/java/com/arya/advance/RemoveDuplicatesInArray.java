package com.arya.advance;

import java.util.Arrays;

public class RemoveDuplicatesInArray {

	public static void main(String[] args) {

	/*	//1.standard way
		int array[] = new int[] { 1, 2, 1, 4, 3, 4, 3, 2 };

		for (int i = 0; i < array.length; i++) {

			for (int j = i + 1; j < array.length; j++) {

				if (array[i] == array[j])
					array[i] = -1;

			}
		}
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] != -1)
			System.out.println(array[i]);
		}*/


		// 2.use quick sort then use below logic
		int[] arr = new int[]{1, 1, 1, 2, 2, 3, 4, 5};
		int[] result = new int[arr.length];
		int previous = arr[0];
		result[0] = previous;
		int count = 1;

		for (int i = 1; i < arr.length; i++) {

			if (previous != arr[i]) {
				result[count++] = arr[i];
			}
			previous = arr[i];
		}

		System.out.println(Arrays.toString(result));


	}

}
