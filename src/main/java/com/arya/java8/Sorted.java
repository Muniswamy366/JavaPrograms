package com.arya.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorted {
    public static void main(String[] args) {

        // Case 1:
        List<String> names = Arrays.asList("muni", "swamy", "palla", "arya");
        Collections.sort(names, String::compareTo); // sorts collections in place
        // Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("Case 1: " + names);

        // Case 1.1
        // Map Sort by key ASC
        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("rent", 1150);
        Map<String, Integer> ascMapKey = budget.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("Case 1.1: " + ascMapKey);

        // Case 1.2
        // Map Sort by key DESC
        Map<String, Integer> descMapKey = budget.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("Case 1.2: " + descMapKey);
        // Similarly Map.Entry.comparingByValue()

        // Case 1.3
        List<Employee> employees = Arrays.asList(new Employee("muni", 22)
                , new Employee("swamy", 33)
                , new Employee("palla", 44));
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        System.out.println("Case 1.3: " + employees);

        // Case 2
        List<String> case2 = names.stream()
                .sorted()
                //.sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println("Case 2: " + case2); // returns new sorted stream

        // Case 3
        Stream<String> case3 = names.stream()
                .sorted(Comparator.reverseOrder());
        System.out.println("Case 3: " + case3);

        // Case 4:
        Stream<Employee> sortedName = employees.stream()
                .sorted(Comparator.comparing(Employee::getName));
        System.out.println("Case 4: " + sortedName);

        // Case 5:
        Stream<Employee> case5 = employees.stream()
                .sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder()));
        System.out.println("Case 5: " + case5);

        // Case 6
        Stream<Employee> case6 = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge));
        System.out.println("Case 6: " + case6);

        // Case 7
        Stream<Employee> case7 = employees.stream()
                .sorted(Comparator.nullsLast(Comparator.comparing(Employee::getName)));
        System.out.println("Case 7: " + case7);

        // Case 8:
        // provisioning multiple sort keys in a particular sequence
        Stream<Employee> case8 = employees.stream()
                .sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName));
        System.out.println("Case 8: " + case8);

    }
}

class Employee {

    private String name;
    private int age;
    private double salary;
    private int id;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(int id, String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.id = id;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                id == employee.id &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, id);
    }
}

