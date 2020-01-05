package com.arya.simple;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CapitalString {

    public static void main(String[] args) {

        String input = "muni swamy palla";
        String[] names = input.split(" ");
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < names.length; i++) {
            output.append(Character.toUpperCase(names[i].charAt(0)) + names[i].substring(1));
        }

        System.out.println(output);
        System.out.println(convertToTitleCaseJava8(input));
    }

    public static String capitalize(String name) {

        char[] charArray = name.trim().toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
            }
        }

        charArray[0] = Character.toUpperCase(charArray[0]);
        return String.valueOf(charArray);
    }

    public static String convertToTitleCaseJava8(String name) {
        final String SPACE = " ";
        if (name == null || name.isEmpty()) {
            return name;
        }

        return Arrays.stream(name.split(SPACE))
                .map(str -> str.isEmpty() ? str : Character.toTitleCase(str.charAt(0)) + str.substring(1).toLowerCase())
                .collect(Collectors.joining(SPACE));
    }

}
