package com.arya.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class IteratingMap {

	public static void main(String[] args) {

		HashMap<String, String> loans = new HashMap<String, String>();
		loans.put("home loan", "citibank");
		loans.put("personal loan", "Wells Fargo");

		keySetUsingForeach(loans);
		keySetUsingIterator(loans);
		entrySetUsingForeach(loans);
		entrySetUsingIterator(loans);
		entrySetUsingForeachJava8(loans);

	}

	public static void keySetUsingForeach(HashMap<String, String> loans) {

		for (String key : loans.keySet()) {
			System.out.println(key + " : " + loans.get(key));
		}

	}

	public static void keySetUsingIterator(HashMap<String, String> loans) {

		Set<String> keySet = loans.keySet();
		Iterator<String> keySetIterator = keySet.iterator();
		System.out.println("------------------------------------------");
		while (keySetIterator.hasNext()) {

			String key = keySetIterator.next();
			System.out.println(key + " : " + loans.get(key));
		}

	}

	public static void entrySetUsingForeach(HashMap<String, String> loans) {

		Set<Entry<String, String>> entrySet = loans.entrySet();
		System.out.println("------------------------------------------");
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	public static void entrySetUsingIterator(HashMap<String, String> loans) {

		Set<Entry<String, String>> entrySet1 = loans.entrySet();
		Iterator<Entry<String, String>> entrySetIterator = entrySet1.iterator();
		System.out.println("------------------------------------------");
		while (entrySetIterator.hasNext()) {
			Entry<String, String> entry = entrySetIterator.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	public static void entrySetUsingForeachJava8(HashMap<String, String> loans) {
		System.out.println("------------------------------------------");
		loans.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
	}

}
