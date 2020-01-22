package com.arya.java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringJoin {
    public static void main(String[] args) {

        // Case 1
        String case1 = String.join("|", "Citibank", "Bank of America", "Chase");
        System.out.println("Case 1: " + case1);

        // Case 2
        List<String> payCompanies = Arrays.asList("Apple pay", "Samsung Pay", "Paypal");
        String case2 = String.join(",", payCompanies);
        System.out.println("Case 2: " + case2);

        // Case 3
        String[] typesOfCards = {"Credit card", "Debit card", "Master Card"};
        String case3 = String.join(":", payCompanies);
        System.out.println("Case 3: " + case3);

        // Case 4
        StringJoiner stringJoiner = new StringJoiner(",", "{", "}");
        stringJoiner.add("one");
        stringJoiner.add("two");
        stringJoiner.add("three");
        System.out.println("Case 4: " + stringJoiner.toString());

    }
}
