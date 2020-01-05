package com.arya.string;

import java.util.Arrays;

public class StringAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("word", "wrdo"));
    }

    public static boolean isAnagram(String word, String anagram) {
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);

        return Arrays.equals(charFromWord, charFromAnagram);
    }

    public static boolean checkAnagram(String first, String second) {

        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);

        for (char ch : characters) {
            int index = sbSecond.indexOf("" + ch);
            if (index != -1) {
                sbSecond.deleteCharAt(index);
            } else {
                return false;
            }
        }

        return sbSecond.length() == 0;
    }

}
