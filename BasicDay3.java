package com.demo.model.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

        System.out.println("Sort employees by name desc");
        employees.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).forEach(System.out::println);

        System.out.println("Sort employees by age, then by name");
        employees.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName)).forEach(System.out::println);

        System.out.println("Get top 3 highest paid employees");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);

        System.out.println("Get lowest 2 paid employees");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).limit(2).forEach(System.out::println);

        System.out.println("Find employee with maximum salary");
        employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).ifPresentOrElse(System.out::println,()-> System.out.println("No Highest salary"));

        System.out.println("Find employee with minimum age");
        employees.stream().min(Comparator.comparingDouble(Employee::getSalary)).ifPresentOrElse(System.out::println,()-> System.out.println("No Lowest salary"));

        System.out.println("Collect all employee names into a comma-separated string");
        String names = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(names);

        System.out.println("Collect salaries into a Set");
        Set<Double> name = employees.stream().map(Employee::getSalary).collect(Collectors.toSet());
        System.out.println(name);

        System.out.println("Collect employees into a Map of id -> name");
        Map<Integer,Double> idName = employees.stream().collect(Collectors.toMap(Employee::getId,Employee::getSalary));
        System.out.println(idName);
    }
}
