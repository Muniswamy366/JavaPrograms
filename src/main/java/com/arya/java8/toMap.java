package com.arya.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class toMap {
    public static void main(String[] args) {

        List<Employee> empList = Arrays.asList(
                new Employee(1, "muni", 16, 1000)
                , new Employee(2, "swamy", 33, 2000)
                , new Employee(3, "palla", 44, 3000)
                , new Employee(4, "muni", 44, 4000));

        // Case 1
        Map<Integer, String> case1 = empList.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println("Case 1: " + case1);

        // Case 2
        Map<Integer, Employee> case2 = empList.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
        System.out.println("Case 2: " + case2);

        // Case 3
        // if duplicate key, collector will not throw an IllegalStateException
        Map<Integer, Employee> case3 = empList.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity(), (oldVal, newVal) -> newVal));
        System.out.println("Case 3: " + case3);

        // Case 4
        LinkedHashMap<Integer, Employee> case4 = empList.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity(), (oldVal, newVal) -> newVal, LinkedHashMap::new));
        System.out.println("Case 4: " + case4); // keeps the order

        // Case 5
        Stream<String> s = Stream.of("apple", "banana", "apricot", "orange", "apple");
        Map<Character, String> case5 = s.collect(
                Collectors.toMap(s1 -> s1.charAt(0), s1 -> s1, (s1, s2) -> s1 + "|" + s2));
        System.out.println("Case 5: " + case5);


    }
}
