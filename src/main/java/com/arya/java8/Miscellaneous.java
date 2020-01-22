package com.arya.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Miscellaneous {
    public static void main(String[] args) {
        Consumer<String> consumer1 = s -> System.out.println(s);
        Consumer<String> consumer2 = System.out::println;

        Comparator<Integer> consumer3 = (i1, i2) -> Integer.compare(i1, i2);
        Comparator<Integer> consumer4 = Integer::compare;

        // and() method
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        // negate() method
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);

        // or() method
        Predicate<String> containsLetterA = p -> p.contains("A");
        Predicate<String> containsLetterB = p -> p.contains("B");
        String containsA = "And";
        boolean outcome = containsLetterA.or(containsLetterB).test(containsA);
        System.out.println(outcome);

        // isEqual() method static method in Predicate interface.
        Predicate<Employee1> standardApplePredicate = Predicate.isEqual(new Employee1("red", 150.0));
        Employee1 testApple = new Employee1("green", 120.0);
        System.out.println(standardApplePredicate.test(testApple));
        System.out.println(standardApplePredicate.test(new Employee1("red", 150.0)));

        // Case 5
        String fileName = "c://lines.txt";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            br.lines().filter(line -> line.contains("ERROR"))
                    .findFirst()
                    .ifPresent(System.out::println);
        } catch (IOException e) {
            //e.printStackTrace();
        }

        // Case 6
        List<String> strings = Arrays.asList("one", "two", "three");
        // will not work on direct list
        Collection<String> collection = new ArrayList<>(strings);
        collection.removeIf(string -> string.length() > 4);
        System.out.println("Case 6: " + strings);

        // Case 7
        List<String> strings1 = Arrays.asList("one", "two", "three");
        // will not work on direct list
        List<String> list = new ArrayList<>(strings1);
        list.replaceAll(String::toUpperCase);
        System.out.println("Case 7: " + list);

        // Case 8
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 10);
        map.put("two", 20);
        map.forEach((key, value) -> System.out.println(key + "-" + value));

        // Case 9
        // Create a properties and add some values
        Map<String, Integer> prop = new HashMap<>();
        prop.put("Pen", 20);
        prop.put("Book", 100);
        //prop.get("rubber") get returns null, we are not sure rubber is null or object doesn't exist.
        System.out.println("Case 9: " + prop.getOrDefault("rubber", 15));

        // map.putIfAbsent(key,value)
        // map.replaceAll((key, oldVal) -> newVal)
        // map.compute(), map.computeIfPresent(), map.computeIfAbsent()
        // map.merge()

    }
}

@Data
@AllArgsConstructor
class Employee1 {
    private String name;
    private double salary;
}
