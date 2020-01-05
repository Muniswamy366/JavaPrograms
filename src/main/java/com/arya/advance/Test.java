package com.arya.advance;

import java.util.Arrays;

public class Test implements Cloneable {

	public static void main(String[] args) {

		/*String string = "aabbccdefatafaz";

		char[] chars = string.toCharArray();
		Set<Character> charSet = new HashSet<Character>();
		for (char c : chars) {
			charSet.add(c);
		}

		StringBuilder sb = new StringBuilder();
		for (Character character : charSet) {
			sb.append(character);
		}
		System.out.println(sb.toString());*/


		int[] arr = new int[]{1, 5, 7, 8, 4, 2, 3, 6, 5, 4};


		int[] temp = new int[10];

		temp[0] = arr[0];
		int k = 0;

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j <= i; j++) {

				if (arr[i] == temp[j]) ;
				else {
					if (k < 10) {
						k++;
						temp[k] = arr[i];
					}
				}

			}

		}

		System.out.println(Arrays.toString(temp));


	}
}
