package com.arya.java8;

import java.util.function.Function;

public class VariableScope {
    static int e = 20;
    int d = 10;

    public static void main(String[] args) {
    }

    public static void m1(int a) {
        int b;
        Function<Integer, Integer> half = c -> {
            //a = 10;
            //b = 10; we can read variables but we can't write values.
            return c + a;
        };
        System.out.println("Case 1: " + half.apply(10));
    }

    public void m2() {
        Function<Integer, Integer> half = c -> {
            d = 20;
            e = 30; // we can read and write variables values.
            return c;
        };
        System.out.println("Case 1: " + half.apply(10));
    }

}
