package com.demo.exam.java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day2_Java8 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(

                new Employee(1, "Alice", "IT", "Female", 60000, LocalDate.of(2021, 5, 10), 28, "Bangalore", "alice@gmail.com", true),
                new Employee(2, "Bob", "HR", "Male", 35000, LocalDate.of(2019, 3, 14), 35, "Delhi", "bob@yahoo.com", true),
                new Employee(3, "Charlie", "Finance", "Male", 75000, LocalDate.of(2022, 7, 1), 42, "Mumbai", "charlie@gmail.com", false),
                new Employee(4, "Diana", "IT", "Female", 28000, LocalDate.of(2018, 11, 30), 25, "Hyderabad", "diana@gmail.com", true),
                new Employee(5, "Eve", "Admin", "Female", 50000, LocalDate.of(2020, 1, 5), 30, "Chennai", "eve@gmail.com", false),
                new Employee(5, "Oliva", "Admin", "Female", 40000, LocalDate.of(2020, 1, 9), 40, "Chennai", "oliva@gmail.com", true)

        );

        System.out.println("Find the Department Having the Highest Average Salary");
        Map<String,Double> averageSalaryByDep =    employees.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSalaryByDep);

        String depWithHighestAvgSalary =  averageSalaryByDep.
              entrySet().stream().
              max(Map.Entry.comparingByValue()).   //  max(Comparator.comparingDouble(Map.Entry::getValue)).
              map(Map.Entry::getKey).
              orElse(null);


        System.out.println("Find Duplicate Employee Emails");
        List<String> listOfDupEmails =  employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getEmail,
                        Collectors.counting())).
                            entrySet().stream()
                               .filter(e->e.getValue()>1).map(Map.Entry::getKey).toList();


        System.out.println("Find the number of active employees in each department");
        Map<String, Long> activeEmpsEachDep = employees.stream().filter(Employee::isActive).
                collect(Collectors.groupingBy(
                        Employee::getDepartment,Collectors.counting()));

    }
}
