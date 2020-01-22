package com.arya.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Gender {
    male, female
}

public class FlatMap {
    public static void main(String[] args) {

        // Case 1:
        String[][] data = new String[][]{{"aa", "b"}, {"ac", "d"}, {"e", "af"}};
        List<String> charList = Arrays.stream(data)
                .flatMap(x -> Arrays.stream(x)) // String[][] to String[]
                .collect(Collectors.toList());
        System.out.println("Case 1: " + charList);


        // Case 2:
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));
        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream) // List<List<String>> to List<String>
                .collect(Collectors.toList());
        System.out.println("Case 2: " + namesFlatStream);


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
        System.out.println("Case 3: " + collect);


        // Case 4:
        Map<String, List<String>> languageNames = new HashMap<>();
        languageNames.put("frontend", Arrays.asList("Javascript", "HTML", "CSS"));
        languageNames.put("backend", Arrays.asList("Go", "Java", "Python", "Ruby"));

        List<String> allLanguages = languageNames.values().stream()
                .flatMap(each -> each.stream())
                .collect(Collectors.toList());
        System.out.println("Case 4: " + allLanguages);


        // Case 5:
        Map<Integer, Map<Gender, List<String>>> allStudentsGorupedByAgeAndThenGender = new HashMap<>();
        HashMap<Gender, List<String>> studentsGroupedByGender = new HashMap<>();
        studentsGroupedByGender.put(Gender.male, Arrays.asList("Christian", "Barack", "Andrew"));
        studentsGroupedByGender.put(Gender.female, Arrays.asList("Andre", "Lorina", "Rakhi"));
        allStudentsGorupedByAgeAndThenGender.put(16, studentsGroupedByGender);

        // i want to get all the student names
        List<String> allLanguages1 = allStudentsGorupedByAgeAndThenGender.values().stream()
                .flatMap(each -> each.values().stream())
                .flatMap(each -> each.stream()).collect(Collectors.toList());
        System.out.println("Case 5: " + allLanguages1);


        // Case 6:
        Optional<String> optional = Optional.of("Inbetween Result");
        Optional<String> flatMap = optional.flatMap(s -> processTheOutput(s));
        System.out.println("Case 6: " + flatMap.get());


        // Case 7:
        int[] integers = {3, 2, 1, 4, 5};
        Stream<int[]> streamOfIntArray = Stream.of(integers);
        int sum = streamOfIntArray.flatMapToInt(x -> Arrays.stream(x)).sum();
        System.out.println("Case 7: " + sum);

    }

    private static Optional<String> processTheOutput(String s) {
        return Optional.of("Applied Transformation");
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