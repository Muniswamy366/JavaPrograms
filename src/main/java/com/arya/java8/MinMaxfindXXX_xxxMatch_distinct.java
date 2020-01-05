package com.arya.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MinMaxfindXXX_xxxMatch_distinct {
    public static void main(String[] args) {

        // Case 1 max
        List<Integer> numbers = Arrays.asList(1, 2, 3, 7, 6);
        Integer case1 = numbers.stream()
                .mapToInt(v -> v)
                .max()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Case 1: " + case1);

        // Case 2 min
        List<Employee> empList = Arrays.asList(
                new Employee("muni", 16, 1000)
                , new Employee("swamy", 33, 2000)
                , new Employee("palla", 44, 3000)
                , new Employee("muni", 44, 4000));
        Employee case2 = empList.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
        System.out.println("Case 2: " + case2);

        // Case 3
        List<String> names = Arrays.asList("muni", "swamy", "palla", "arya", "muni1", "swamy");
        String case3 = names.stream()
                .filter(n -> n.startsWith("m"))
                .findFirst()
                .orElse("");
        System.out.println("Case 3: " + case3);

        // Case 4
        // effective when you parallelize the stream since the first match in any of the examined segments
        String case4 = names.parallelStream()
                .filter(n -> n.startsWith("m"))
                .findAny()
                .orElse("");
        System.out.println("Case 4: " + case4);

        // Case 5
        boolean case5 = names.stream()
                .anyMatch(n -> n.startsWith("m"));
        System.out.println("Case 5: " + case5);

        // Case 6
        boolean case6 = names.stream()
                .allMatch(n -> n.startsWith("m"));
        System.out.println("Case 6: " + case6);

        // Case 7
        boolean case7 = names.stream()
                .noneMatch(n -> n.startsWith("m"));
        System.out.println("Case 7: " + case7);

        // Case 8
        List<String> case8 = names.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Case 8: " + case8);

    }
}
