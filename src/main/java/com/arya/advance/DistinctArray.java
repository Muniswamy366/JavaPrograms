package com.arya.advance;


public class DistinctArray {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 1, 2, 2, 3, 4, 5};
        int[] temp = new int[9];


	/*	int[] result = new int[arr.length];
		int previous = arr[0];
		result[0] = previous;
		int count =0;

		for (int i = 1; i < arr.length; i++) {
			int ch = arr[i];

			if (previous != ch) {
				result[count++] = previous;
			}
			previous = ch;
		}*/

        //System.out.println(Arrays.toString(result));


        for (int i = 1; i < arr.length; i++) {
            boolean isDistinct = false;
            for (int j = i - 1; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDistinct = true;
                    break;
                }
            }
            if (!isDistinct) {
                System.out.print(arr[i - 1] + " ");
            }
        }

    }
}
