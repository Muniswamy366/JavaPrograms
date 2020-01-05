package com.arya.advance;

import java.util.*;

class Test1 {
	public static void sortByValue(Map<String, Integer> unsortedMap) {
		Set<Map.Entry<String, Integer>> set = unsortedMap.entrySet();
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
		Collections.sort(list, new ValueComparator1());

		System.out.println("Sort by value: ");
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	public static void sortByKey(Map<String, Integer> unsortedMap) {
		Set<Map.Entry<String, Integer>> set = unsortedMap.entrySet();
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
		Collections.sort(list, new KeyComparator1());

		System.out.println("Sort by key: ");
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}

class ValueComparator1 implements Comparator<Map.Entry<String, Integer>> {

	public ValueComparator1() {
	}

	public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
		return entry1.getValue().compareTo(entry2.getValue());
	}
}

class KeyComparator1 implements Comparator<Map.Entry<String, Integer>> {

	public KeyComparator1() {
	}

	public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
		return entry1.getKey().compareTo(entry2.getKey());
	}
}

public class MapSortNormalWay {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		// *value Class should implements the Comparable interface
		// *String implements Comparable by default.
		map.put("Z", 3);
		map.put("D", 4);
		map.put("A", 1);
		map.put("B", 2);
		map.put("F", 6);
		map.put("E", 5);

		System.out.println("Unsorted Map: " + map);
		Test1.sortByValue(map);
		Test1.sortByKey(map);
	}
}
