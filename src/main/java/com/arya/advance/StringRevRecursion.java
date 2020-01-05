package com.arya.advance;

public class StringRevRecursion {

    public static String reverseStr(String str) {
        String rev = "";
        if (str.length() == 1)
            return str;
        else
            rev += str.charAt(str.length() - 1) + reverseStr(str.substring(0, str.length() - 1));
        return rev;
    }

    public static void main(String[] args) {

        System.out.println(reverseStr("123456"));

    }
}
