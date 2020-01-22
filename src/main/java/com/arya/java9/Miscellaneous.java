package com.arya.java9;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Miscellaneous {
    public static void main(String[] args) {

        // Case 1
        List<String> case1 = List.of("Lokesh", "Amit", "John");

        //names.add("Brian"); //UnsupportedOperationException occured

        //java.lang.NullPointerException
        //List<String> names2 = List.of("Lokesh", "Amit", "John", null);

        // Case 2
        Set<String> case2 = Set.of("Lokesh", "Amit", "John");

        //names.add("Brian"); //UnsupportedOperationException occured

        //java.lang.NullPointerException
        //Set<String> names2 = Set.of("Lokesh", "Amit", "John", null);

        //java.lang.IllegalArgumentException
        //Set<String> names3 = Set.of("Lokesh", "Amit", "John", "Amit");


        // Case 3
        Map<String, String> case3 = Map.ofEntries(
                Map.entry("1", "Lokesh"),
                Map.entry("2", "Amit"),
                Map.entry("3", "Brian"));

        //UnsupportedOperationException
        //names.put("2", "Ravi");


        // Case 4
        getEmployeeName(null).forEach(System.out::println); // Empty
        getEmployeeName(new Book(1, List.of("muni", "swamy"), 1.0)).forEach(System.out::println);


        // Case 5
        List<Integer> numbers = List.of(2, 3, 4, 7, 9, 11);
        // Java 8 Way
        Map<Integer, Long> case5temp = numbers.stream().filter(j -> j > 5).collect(Collectors.groupingBy(i -> i % 2, Collectors.counting()));
        System.out.println("Case 5: " + case5temp);
        // {1=3}
        // Java 9 Way
        Map<Integer, Long> case5 = numbers.stream().collect(Collectors.groupingBy(i -> i % 2, Collectors.filtering(j -> j > 5, Collectors.counting())));
        System.out.println("Case 5: " + case5);
        // {0=0, 1=3}


        // Case 6
        Stream<Map.Entry<Integer, Set<String>>> entries = Stream.of(Map.entry(1, Set.of("a", "b")), Map.entry(1, Set.of("a", "c")), Map.entry(2, Set.of("d")));
        // Java 8 Way
        Map<Integer, Set<Set<String>>> case6temp = entries.collect(Collectors.groupingBy(e -> e.getKey(), Collectors.mapping(e -> e.getValue(), Collectors.toSet())));
        System.out.println("Case 6: " + case6temp);
        // {1=[[a, b], [a, c]], 2=[[d]]}
        entries = Stream.of(Map.entry(1, Set.of("a", "b")), Map.entry(1, Set.of("a", "c")), Map.entry(2, Set.of("d")));
        // Java 9 Way more readable
        Map<Integer, Set<String>> case6 = entries.collect(Collectors.groupingBy(e -> e.getKey(), Collectors.flatMapping(e -> e.getValue().stream(), Collectors.toSet())));
        System.out.println("Case 6: " + case6);
        // {1=[a, b, c], 2=[d]}


        // Case 17
        List<Employee2> empList = List.of(new Employee2("Sara", new Department("Admin"), 3000),
                new Employee2("Joe", new Department("IT"), 1000),
                new Employee2("Mike", new Department("Account"), 2000),
                new Employee2("Tony", new Department("Account"), 1500),
                new Employee2("Linda", new Department("IT"), 5000));
        Map<Department, Set<Employee2>> case17 = empList.stream().collect(Collectors.groupingBy(Employee2::getDept, Collectors.filtering(e -> e.getSalary() >= 2000, Collectors.toSet())));
        System.out.println("Case 17: ");
        case17.forEach((k, v) -> System.out.printf("%8s: %s%n", k.getName(), v));


    }

    private static Stream<String> getEmployeeName(Book book) {
        return Stream.ofNullable(book).flatMap(e -> e.getAuthors().stream());
    }
}

@Data
@AllArgsConstructor
class Book {
    private int id;
    private List<String> authors;
    private double price;
}

@Data
@AllArgsConstructor
class Employee2 {
    private String name;
    private Department dept;
    private int salary;
}

@Data
@AllArgsConstructor
class Department {
    private String name;
}