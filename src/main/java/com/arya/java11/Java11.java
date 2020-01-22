package com.arya.java11;

import java.util.function.Predicate;

public class Java11 {
    public static void main(String[] args) {

        // repeat
        System.out.println("muni".repeat(4));

        // isEmpty
        String name = "   muni ";
        String name1 = null; // won't work
        System.out.println(name.isEmpty());

        // strip
        String txt = "\n \t      muni     \u2005";
        System.out.println(txt.strip());

        // lines
        String lines = "muni\nswamy\npalla";
        lines.lines().forEach(System.out::print);

        // Files.readString and Files.writeString
        // reading file as string no need to close file.

        // Optional::isEmpty

        // Predicate::not

        // Java 11 Unicode 10

        // we can use var in lambdas
        Predicate<String> predicate = (var s1) -> s1.length() < 3;

    }
}
