package com.arya.advance;

import java.util.*;
import java.util.Map.Entry;

public class MapSortByValue {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("java", 20);
		map.put("C++", 45);
		map.put("Java2Novice", 2);
		map.put("Unix", 67);
		map.put("MAC", 26);
		map.put("Why this kolavari", 93);

		Set<Entry<String, Integer>> set = map.entrySet();

		List<Entry<String, Integer>> list = new ArrayList<>(set);

		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
							   Entry<String, Integer> o2) {
				return -(o1.getValue().compareTo(o2.getValue()));
			}

		});

		System.out.println(list);

	}

}
