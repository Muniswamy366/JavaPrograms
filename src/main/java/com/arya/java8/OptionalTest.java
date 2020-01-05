package com.arya.java8;

import java.util.Optional;

@FunctionalInterface
interface DefaultValue {
    static String getDefault() {
        System.out.println("DefaultValue");
        return "arya";
    }

    void m1();
}

public class OptionalTest {

    public static String getDefault() {
        System.out.println("OptionalTest");
        return "arya";
    }

    public static void main(String[] args) {

        int n = args.length;
        // Case 1
        String name = "muni";
        //String name = null; // if name is null, NullPointerException
        Optional<String> case1 = Optional.of(name);
        if (case1.isPresent()) {
            System.out.println("Case 1: " + case1.get());
        }

        // Case 2
        Optional<String> case2 = Optional.empty();
        System.out.println("Case 2: " + case2.isPresent());

        // Case 3
        name = null;
        Optional<String> case3 = Optional.ofNullable(name);
        System.out.println("Case 3: " + case3.isPresent()); // fasle, no NPE

        // Case 4
        name = "muni";
        //name = null;
        String case4 = Optional.ofNullable(name)
                .orElse(getDefault()); // default value
        // OptionalTest getDefault() will be invoked even when the value is present
        System.out.println("Case 4: " + case4);

        // Case 5
        name = "muni";
        //name = null;
        String case5 = Optional.ofNullable(name)
                .orElseGet(DefaultValue::getDefault);
        // DefaultValue getDefault() will not invoked even when the value is present
        System.out.println("Case 5: " + case5);

        // Case 6
        //name = null;
        String case6 = Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);
        System.out.println("Case 6: " + case6);
    }
}