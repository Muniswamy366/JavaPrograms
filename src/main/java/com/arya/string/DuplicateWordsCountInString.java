package com.arya.string;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DuplicateWordsCountInString {

	public static void main(String[] args) {

		System.out.println(duplicateWords("this is muni swamy muni hello swamy hello"));
	}

	public static Set<String> duplicateWords(String input) {

		if (input == null || input.isEmpty()) {
			return Collections.emptySet();
		}
		Set<String> duplicates = new HashSet<>();

		String[] words = input.split("\\s+");
		Set<String> set = new HashSet<>();

		for (String word : words) {
			if (!set.add(word)) {
				duplicates.add(word);
			}
		}
		return duplicates;
	}

}
