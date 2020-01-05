package com.arya.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterMapCollectors {
    public static void main(String[] args) {

        // https://www.baeldung.com/java-8-collectors

        // Case 1:
        List<String> namesList = Arrays.asList("muni", "swamy", "palla", "arya");
        namesList.stream()
                .filter(name -> name.contains("a"))
                .forEach(p -> System.out.print(p));
        namesList.stream()
                .filter(name -> name.contains("a"))
                .forEach(System.out::println);

        // Case 2:
        Stream<String> numberStream = Arrays.stream(new String[]{"3", "6", "8", "14", "15"});
        int sum = numberStream.mapToInt(Integer::parseInt).sum();
        System.out.println("Case 2: " + sum);

        // Case 3:
        Stream<String> numberStream1 = Arrays.stream(new String[]{"3", "6", "8", "14", "15"});
        numberStream1.mapToInt(num -> Integer.parseInt(num))
                .filter(num -> num % 3 == 0)
                .forEach(System.out::println);

        // Case 4:
        List<Employee> employeeList = Arrays.asList(
                new Employee("muni", 16, 1000)
                , new Employee("swamy", 33, 2000)
                , new Employee("palla", 44, 3000)
                , new Employee("muni", 44, 4000));
        List<Employee> case4 = employeeList.stream()
                .filter(emp -> emp.getAge() >= 18)
                .collect(Collectors.toList());
        System.out.println("Case 4: " + case4);

        // Case 5:
        Employee case5 = employeeList.stream()
                .filter(x -> "muni".equals(x.getName()))
                .findAny()
                .orElse(null);
        System.out.println("Case 5: " + case5);

        // Case 6:
        String name = employeeList.stream()
                .filter(x -> "muni".equals(x.getName()))
                .map(Employee::getName)                        //convert stream to String
                .findAny()
                .orElse("");
        System.out.println("Case 6: " + name);

        // Case 7:
        List<String> case7 = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Case 7: " + case7);

        // Case 8:
        List<String> case8 = namesList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Case 8: " + case8);

        // Case 9:
        List<Employee> case9 = employeeList.stream().map(emp -> {
            emp.setSalary(1000); // not sure i can do this check later
            return emp;
        }).collect(Collectors.toList());
        System.out.println("Case 9: " + case9);

        // Case 10:
        Employee[] employees = employeeList.stream()
                .toArray(Employee[]::new);
        System.out.println("Case 10: " + Arrays.toString(employees));

        // Case 11:
        long case11 = namesList.stream()
                .mapToInt(String::length).sum();
        System.out.println("Case 11: " + case11);

        // Case 12:
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> case12 = num.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Case 12: " + case12);

        // Collectors
        // Case 13:
        // toSet()
        List<String> case13 = namesList.stream()
                .collect(Collectors.toList());
        System.out.println("Case 13: " + case13);

        // Case 14:
        Map<String, Integer> case14 = namesList.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("Case 14: " + case14);

        // Case 15
        List<String> case15 = namesList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println("Case 15: " + case15);

        // Case 16
        String case16 = namesList.stream()
                .collect(Collectors.joining(","));
        System.out.println("Case 16: " + case16);

        // Case 17
        // HashSet::new
        List<String> case17 = namesList.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Case 17: " + case17);

        // read more about Collecctors
        // https://www.java67.com/2018/11/10-examples-of-collectors-in-java-8.html


    }
}
