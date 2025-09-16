package com.demo.model.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicDay6 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", "Female", 60000, LocalDate.of(2021, 5, 10), 28, "Bangalore", "alice@gmail.com", true),
                new Employee(2, "Bob", "HR", "Male", 35000, LocalDate.of(2019, 3, 14), 35, "Delhi", "bob@yahoo.com", true),
                new Employee(3, "Charlie", "Finance", "Male", 75000, LocalDate.of(2022, 7, 1), 42, "Mumbai", "charlie@gmail.com", false),
                new Employee(4, "Diana", "IT", "Female", 28000, LocalDate.of(2018, 11, 30), 25, "Hyderabad", "diana@gmail.com", true),
                new Employee(5, "Eve", "Admin", "Female", 50000, LocalDate.of(2020, 1, 5), 30, "Chennai", "eve@gmail.com", false)
        );

        System.out.println("Sort employees by salary in ascending order");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);

        System.out.println("Sort employees by salary in descending order");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);

        System.out.println("Sort employees by department, then by name");
        employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getName)).forEach(System.out::println);

        System.out.println("Group employees by department");
        Map<String, List<Employee>> list = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        list.forEach((department, employee) -> System.out.println(department + ":" + employee));

        System.out.println("Count employees in each department");
        Map<String, Long> count = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(count);

        System.out.println("Find average salary by department");
        Map<String, Double> average = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(average);

        System.out.println("Highest-paid employee in each department");
        Map<String, Optional<Employee>> highestPaid = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(highestPaid);

        System.out.println("Group employees by city");
        Map<String, List<Employee>> groupByCity = employees.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println(groupByCity);

        System.out.println("Find youngest employee in each department");
        Map<String,Optional<Employee>> youngest=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparingInt(Employee::getAge))));
        System.out.println(youngest);
    }
}