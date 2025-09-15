package com.demo.model.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BasicDay5 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", "Female", 60000, LocalDate.of(2021, 5, 10), 28, "Bangalore", "alice@gmail.com", true),
                new Employee(2, "Bob", "HR", "Male", 35000, LocalDate.of(2019, 3, 14), 35, "Delhi", "bob@yahoo.com", true),
                new Employee(3, "Charlie", "Finance", "Male", 75000, LocalDate.of(2022, 7, 1), 42, "Mumbai", "charlie@gmail.com", false),
                new Employee(4, "Diana", "IT", "Female", 28000, LocalDate.of(2018, 11, 30), 25, "Hyderabad", "diana@gmail.com", true),
                new Employee(5, "Eve", "Admin", "Female", 50000, LocalDate.of(2020, 1, 5), 30, "Chennai", "eve@gmail.com", false)
        );

        System.out.println("Count total number of employees");
        long totalEmployees= employees.stream().count(); //employees.size() also will return the same
        System.out.println(totalEmployees);

        System.out.println("Count active employees");
        long activeEmployees = employees.stream().filter(Employee::isActive).count();
        System.out.println(activeEmployees);

        System.out.println("Sum of all employees’ salaries");
        double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(totalSalary);

        System.out.println("Average salary of employees");
        double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        System.out.println(averageSalary);

        System.out.println("Highest salary among employees");
        double highestSalary=  employees.stream().mapToDouble(Employee::getSalary).max().orElse(0.0);
        System.out.println(highestSalary);

        System.out.println("Lowest age among employees");
        long lowestAge = employees.stream().mapToLong(Employee::getAge).min().orElse(0);
        System.out.println(lowestAge);

        System.out.println("Average age of employees in IT department");
        double averageAge = employees.stream().mapToLong(Employee::getAge).average().orElse(0.0);
        System.out.println(averageAge);

        System.out.println("Get salary statistics");
        DoubleSummaryStatistics statistics = employees.stream().mapToDouble(Employee::getSalary).summaryStatistics();
        System.out.println(statistics);

        System.out.println("Find name of employee with highest salary");
        Optional<String> nameOfHighestSalaryEmp = employees.stream().max(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getName);
        System.out.println(nameOfHighestSalaryEmp);

        System.out.println("Find department with maximum employees");
        String maxDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
                        .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("No dept");
        System.out.println("Dept with max employees: " + maxDept);


    }
}

