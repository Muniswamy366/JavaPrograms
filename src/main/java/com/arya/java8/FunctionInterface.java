package com.arya.java8;

import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {

        // Case 1:
        Function<Integer, Double> half = a -> a / 2.0;
        System.out.println("Case 1: " + half.apply(10));

        // Case 2:
        Function<Integer, String> evenOdd = (t) -> {
            if (t % 2 == 0) {
                return t + " is even number";
            } else {
                return t + " is odd number";
            }
        };
        System.out.println("Case 2: " + evenOdd.apply(5));

        // Case 3:
        Function<Integer, Integer> function1 = t -> (t - 5);
        Function<Integer, Integer> function2 = t -> (t * 2);
        // first executes function1 then function2
        int a = function1.andThen(function2).apply(50);
        System.out.println("Case 3: " + a);

        // Case 4:
        // first executes function2 then function1
        int c = function1.compose(function2).apply(50);
        System.out.println("Case 4: " + c);

        // Case 5:
        // This method returns a function which returns its only argument.
        Function.identity();
    }
}
