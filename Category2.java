package com.demo.model.java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Category2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", "Female", 60000, LocalDate.of(2021, 5, 10), 28, "Bangalore", "alice@gmail.com", true),
                new Employee(2, "Bob", "HR", "Male", 35000, LocalDate.of(2019, 3, 14), 35, "Delhi", "bob@yahoo.com", true),
                new Employee(3, "Charlie", "Finance", "Male", 75000, LocalDate.of(2022, 7, 1), 42, "Mumbai", "charlie@gmail.com", false),
                new Employee(4, "Diana", "IT", "Female", 28000, LocalDate.of(2018, 11, 30), 25, "Hyderabad", "diana@gmail.com", true),
                new Employee(5, "Eve", "Admin", "Female", 50000, LocalDate.of(2020, 1, 5), 30, "Chennai", "eve@gmail.com", false)
        );

        System.out.println("get all employee names");
       List<String> list = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(list);

        System.out.println("get only emails of all employees");
        employees.stream().map(Employee::getEmail).forEach(System.out::println);

        System.out.println("Get list of employee IDs");
        List<Integer> list1 = employees.stream().map(Employee::getId).collect(Collectors.toList());
        System.out.println(list1);

        System.out.println("Convert all names to uppercase");
        employees.stream().map(e->e.getName().toUpperCase()).forEach(System.out::println);

        System.out.println("Get name and department as a combined string");
        employees.stream().map(e->e.getName()+":"+e.getDepartment()).forEach(System.out::println);

        System.out.println("Get employee ages as a list");
        employees.stream().map(Employee::getAge).forEach(System.out::println);

        System.out.println("Get names of employees who are active");
        employees.stream().filter(e->e.isActive()).map(Employee::getName).forEach(System.out::println);

        System.out.println("Get city names without duplicates");
        employees.stream().map(Employee::getCity).distinct().forEach(System.out::println);

        System.out.println("Get the length of each employee’s name");
        employees.stream().map(e->e.getName().length()).forEach(System.out::println);

    }
}
