package com.arya.string;

import java.util.ArrayList;

/*To get all the permutations, we will first take out the first char from String and permute the remaining chars.
If String = �ABC�
First char = A and remaining chars permutations are BC and CB.
Now we can insert first char in the available positions in the permutations.
BC -> ABC, BAC, BCA
CB -> ACB, CAB, CBA*/

public class AllPermutations {

	/*public static Set<String> permutationFinder(String str) {
		Set<String> perm = new HashSet<String>();
		// Handling error scenarios
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		Set<String> words = permutationFinder(rem);
		System.out.println(words);
		for (String strNew : words) {
			for (int i = 0; i <= strNew.length(); i++) {
				perm.add(charInsert(strNew, initial, i));
			}
		}
		return perm;
	}

	public static String charInsert(String str, char c, int j) {
		System.out.println("came ...");
		String begin = str.substring(0, j);
		String end = str.substring(j);
		String res = begin + c + end;
		System.out.println("res "+res);
		return res;
	}*/

	public static void main(String[] args) {
		String s = "AAC";
		String s1 = "ABC";
		String s2 = "ABCD";
		//	System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
		//	System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
		//	System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));

		permutation("ABC");

		ArrayList<Integer> list = new ArrayList<Integer>();

	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}
}
