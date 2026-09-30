package com.demo.exam.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Day1_Java8 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", "Female", 60000, LocalDate.of(2021, 5, 10), 28, "Bangalore", "alice@gmail.com", true),
                new Employee(2, "Bob", "HR", "Male", 35000, LocalDate.of(2019, 3, 14), 35, "Delhi", "bob@yahoo.com", true),
                new Employee(3, "Charlie", "Finance", "Male", 75000, LocalDate.of(2022, 7, 1), 42, "Mumbai", "charlie@gmail.com", false),
                new Employee(4, "Diana", "IT", "Female", 28000, LocalDate.of(2018, 11, 30), 25, "Hyderabad", "diana@gmail.com", true),
                new Employee(5, "Eve", "Admin", "Female", 50000, LocalDate.of(2020, 1, 5), 30, "Chennai", "eve@gmail.com", false),
                new Employee(5, "Oliva", "Admin", "Female", 40000, LocalDate.of(2020, 1, 9), 40, "Chennai", "oliva@gmail.com", true)

        );

        System.out.println("Find Highest Paid Employee in Each Department");
        Map<String, Employee> highestPaidEmployeeInEachDep = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                     Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                             Optional::get)));
        highestPaidEmployeeInEachDep.forEach((e,k)-> System.out.println(e + ": " +k.getName()));


        System.out.println("Find Employees Earning More Than Their Department Average Salary");
        Map<String,Double> avgSalaryByDep = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

        employees.stream()
                .filter(e->e.getSalary()  > avgSalaryByDep.get(e.getDepartment())).
                     forEach(s-> System.out.println(s.getDepartment()+":"+s.getName()));
    }
}
