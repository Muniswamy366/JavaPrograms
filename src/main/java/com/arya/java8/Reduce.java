package com.arya.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {

        // Case 1:
        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

        // The lambda expression passed to reduce() method takes two Strings and returns the longer String.
        // The result of the reduce() method is an Optional because the list on which reduce() is called may be empty.
        Optional<String> longestString = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        if (longestString.isPresent()) {
            System.out.println("Case 1: " + longestString.get());
        }


        // Case 2:
        // String array
        String[] array = {"Geeks", "for", "Geeks"};
        Optional<String> string_combine = Arrays.stream(array)
                .reduce((str1, str2) -> str1 + "-" + str2);
        if (string_combine.isPresent()) {
            System.out.println("Case 2: " + string_combine.get());
        }


        // Case 3:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers.stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        // It stores the initial value of the reduction operation, and also the default result when the stream of Integer values is empty.
        System.out.println("Case 3: " + result);


        // Case 4
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String case4 = letters.stream()
                .reduce("", (partialString, element) -> partialString + element);
        System.out.println("Case 4: " + case4);

        // Case 5
        String case5 = letters.stream()
                .reduce("", String::concat);
        System.out.println("Case 5: " + case5);


    }
}
