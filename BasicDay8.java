package com.demo.model.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BasicDay8 { //Advanced Collectors
    public static void main(String[] args) {
        
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", "Female", 60000, LocalDate.of(2021, 5, 10), 28, "Bangalore", "alice@gmail.com", true),
                new Employee(2, "Bob", "HR", "Male", 35000, LocalDate.of(2019, 3, 14), 35, "Delhi", "bob@yahoo.com", true),
                new Employee(3, "Charlie", "Finance", "Male", 75000, LocalDate.of(2022, 7, 1), 42, "Mumbai", "charlie@gmail.com", false),
                new Employee(4, "Diana", "IT", "Female", 28000, LocalDate.of(2018, 11, 30), 25, "Hyderabad", "diana@gmail.com", true),
                new Employee(5, "Eve", "Admin", "Female", 50000, LocalDate.of(2020, 1, 5), 30, "Chennai", "eve@gmail.com", false)
        );

        System.out.println("Group employees by department");
        Map<String,List<Employee>> groupEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groupEmployees.forEach((s, employees1) -> System.out.println(s+":"+employees1));

        System.out.println("Count employees in each department");
        Map<String, Long> countEmployeesByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(countEmployeesByDept);

        System.out.println("Find average salary by department");
        Map<String,Double> avgerageSaralyByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgerageSaralyByDept);

        System.out.println("Find highest salary in each department");
        Map<String, Optional<Employee>>  highestSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(highestSalaryByDept);

        System.out.println("Partition employees into active & inactive");
        Map<Boolean,List<Employee>> employeePartition = employees.stream().collect(Collectors.groupingBy(Employee::isActive));
        System.out.println(employeePartition);

        System.out.println("Join all employee names with comma");
        String names = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(names);

        System.out.println("Find oldest employee in each department");
        Map<String,Optional<Employee>> oldestEmployeeByAge = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getAge))));
        System.out.println(oldestEmployeeByAge);

        System.out.println("Find total salary paid in each city");
        Map<String,Double> totalSalaryByCity = employees.stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.summingDouble(Employee::getSalary)));
        System.out.println(totalSalaryByCity);

        System.out.println("Map department to list of employee names");
        Map<String,List<String>> depToNames = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
        System.out.println(depToNames);

        System.out.println("Find the most populated department");
        String name = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("No Dept");
        System.out.println(name);

    }
}

