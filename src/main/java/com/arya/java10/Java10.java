package com.arya.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Java10 {
    public static void main(String[] args) {
        var str = "muni"; // type will get from right side of expression
        var var = "var"; // compiles
        // var is not a keyword

        List<String> list = new ArrayList<>(); // type will get from left side.
        Predicate<String> string = str1 -> str1.length() > 3; // type will get from left side.

    }
}
