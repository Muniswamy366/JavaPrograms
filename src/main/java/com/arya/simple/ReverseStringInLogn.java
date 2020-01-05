package com.arya.simple;

public class ReverseStringInLogn {

    public static void main(String[] args) {

        String name = "abcdef";
        char[] chars = name.toCharArray();
        int n = chars.length;

        for (int i = 0; i < chars.length / 2; i++) {
            char ch = chars[n - 1 - i];
            chars[n - 1 - i] = chars[i];
            chars[i] = ch;
        }

        System.out.println(String.valueOf(chars));
    }
}
