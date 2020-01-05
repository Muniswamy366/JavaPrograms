package com.arya.simple;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountCharInString {

	public static void main(String[] args) {
		String s = "muniminmin";
		
		/*Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				int cnt = map.get(c);
				map.put(c, ++cnt);
			} else {
				map.put(c, 1);
			}
		}
		System.out.println(map);*/

		int count = 1;
		char[] ch = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			if (ch[i] != '*') {
				for (int j = i + 1; j < s.length(); j++) {
					if (ch[i] == ch[j]) {
						count++;
						ch[j] = '*';
					}
				}
			}
			if (ch[i] != '*')
				System.out.println(ch[i] + "  " + count);
			count = 1;
		}

		java8(s);
	}

	public static void java8(String text) {
		Map<String, Long> collect = Arrays.stream(text.split(""))
				.collect(Collectors.groupingBy(str -> str, Collectors.counting()));
		System.out.println(collect);
	}
}
