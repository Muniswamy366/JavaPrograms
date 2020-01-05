package com.arya.java8;

import java.util.*;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {

        // Case 1:
        String[][] data = new String[][]{{"aa", "b"}, {"ac", "d"}, {"e", "af"}};
        List<String> charList = Arrays.stream(data)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());
        System.out.println(charList);

        // Case 2:
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));
        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(namesFlatStream);

        // Case 3:
        Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8");
        obj1.addBook("Java 9");
        obj1.addBook("Java 10");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Java 8");
        obj2.addBook("Java 11");

        List<Student> studentList = new ArrayList<>();
        studentList.add(obj1);
        studentList.add(obj2);

        List<String> collect = studentList.stream()
                .map(x -> x.getBook())      //Stream<Set<String>>
                .flatMap(x -> x.stream())   //Stream<String>
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}


class Student {

    private String name;
    private Set<String> book;

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }
}