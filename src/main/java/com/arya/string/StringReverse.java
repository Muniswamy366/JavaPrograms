package com.arya.string;

import java.util.Stack;

public class StringReverse {

	public static String reverse(String str) {
		StringBuilder strBuilder = new StringBuilder();
		char[] strChars = str.toCharArray();

		for (int i = strChars.length - 1; i >= 0; i--) {
			strBuilder.append(strChars[i]);
		}

		return strBuilder.toString();
	}

	public static String reverseWithStack(String str) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < str.length(); i++)
			stack.push(str.charAt(i));

		for (int j = 0; j < str.length(); j++) {
			char ch = stack.pop();
			stringBuilder.append(ch);
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {

		System.out.println("Reverse String in Java using StringBuffer: " + reverse("muni"));
		System.out.println("Reverse String in Java using StringBuffer: " + reverse("arya"));

	}

}
