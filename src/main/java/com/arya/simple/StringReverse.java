package com.arya.simple;

public class StringReverse {

    public static void main(String[] args) {
        StringReverse obj = new StringReverse();
        String str = "Muni";
        System.out.println("Reverse of '" + str + "' is '" + obj.reverse(str) + "'");
    }

    public String reverse(String str) {
        if ((str == null) || (str.length() <= 1))
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    // Here the 'reverse' method takes the first character of the String
    // str.charAt(0) puts it at the end and then calls itself, on the remainder
    // str.substring(1), and adding those things together to get the result
    // reverse(str.substring(1)) + str.charAt(0)
    //reverse("Muni")
    //(reverse("uni")) + "M"
    //((reverse("ni")) + "u") + "M"
    //(((reverse("i")) + "n") + "u") + "M"
    //(((("i") + "n") + "u") + "Q"
}
