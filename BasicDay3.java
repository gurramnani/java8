package com.demo.model.java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BasicDay3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", "Female", 60000, LocalDate.of(2021, 5, 10), 28, "Bangalore", "alice@gmail.com", true),
                new Employee(2, "Bob", "HR", "Male", 35000, LocalDate.of(2019, 3, 14), 35, "Delhi", "bob@yahoo.com", true),
                new Employee(3, "Charlie", "Finance", "Male", 75000, LocalDate.of(2022, 7, 1), 42, "Mumbai", "charlie@gmail.com", false),
                new Employee(4, "Diana", "IT", "Female", 28000, LocalDate.of(2018, 11, 30), 25, "Hyderabad", "diana@gmail.com", true),
                new Employee(5, "Eve", "Admin", "Female", 50000, LocalDate.of(2020, 1, 5), 30, "Chennai", "eve@gmail.com", false)
        );

        System.out.println("Sort employees by name asc");
        employees.stream().sorted(Comparator.comparing(a->a.getName())).forEach(System.out::println);

        System.out.println("Sort employees by name desc");
        employees.stream().sorted(Comparator.comparing(a->a.getName()).reversed()).forEach(System.out::println);

        System.out.println("Sort employees by age, then by name");
        employees.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName)).forEach(System.out::println);

        System.out.println("Get top 3 highest paid employees");
        employees.stream().s

    }
}
