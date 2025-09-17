package com.demo.model.java8;

import java.time.LocalDate;
import java.util.*;

public class BasicDay7 {

    //Aggregation & Statistics

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", "Female", 60000, LocalDate.of(2021, 5, 10), 28, "Bangalore", "alice@gmail.com", true),
                new Employee(2, "Bob", "HR", "Male", 35000, LocalDate.of(2019, 3, 14), 35, "Delhi", "bob@yahoo.com", true),
                new Employee(3, "Charlie", "Finance", "Male", 75000, LocalDate.of(2022, 7, 1), 42, "Mumbai", "charlie@gmail.com", false),
                new Employee(4, "Diana", "IT", "Female", 28000, LocalDate.of(2018, 11, 30), 25, "Hyderabad", "diana@gmail.com", true),
                new Employee(5, "Eve", "Admin", "Female", 50000, LocalDate.of(2020, 1, 5), 30, "Chennai", "eve@gmail.com", false)
        );

        System.out.println("Find the total salary of all employees");
        double sumOfEmpSalaries =  employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sumOfEmpSalaries);

        System.out.println("Find the average salary of employees");
        double averageSalaries =  employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        System.out.println(averageSalaries);

        System.out.println("Find the employee with the highest salary");
        Employee maxSalary =  employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        System.out.println(maxSalary);

        System.out.println("Find the employee with the lowest salary");
        Employee minSalary = employees.stream().min(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        System.out.println(minSalary);

        System.out.println("Count total employees");
        long countEmployees = employees.stream().count();
        System.out.println(countEmployees);

        System.out.println("Find average age of employees");
        double averageAge = employees.stream().mapToLong(Employee::getAge).average().orElse(0.0);
        System.out.println(averageAge);

        System.out.println("Salary statistics summary");
        DoubleSummaryStatistics doubleSummaryStatistics = employees.stream().mapToDouble(Employee::getSalary).summaryStatistics();
        System.out.println(doubleSummaryStatistics);

        System.out.println("Find employee with minimum age");
        Employee minAge = employees.stream().min(Comparator.comparingLong(Employee::getAge)).orElse(null);
        System.out.println(minAge);
    }
}
