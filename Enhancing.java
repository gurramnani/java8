package com.demo.exam;

import com.demo.model.java8.Staff;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Enhancing {
    public static void main(String[] args) {
        
        List<Staff> staffList = Arrays.asList(
                new Staff("Alice Johnson", "alice@mail.com", Arrays.asList("BankingApp", "Ecommerce"), 60000, "Finance", true),
                new Staff("Bob Smith", "bob@mail.com", Arrays.asList("BankingApp", "Insurance"), 75000, "IT", false),
                new Staff("Charlie Brown", "charlie@mail.com", Arrays.asList("Healthcare", "Ecommerce"), 50000, "HR", true)
        );

        System.out.println("Find the names of all staff whose salary is greater than 60,000. (filter + map)");
        staffList.stream().filter(e -> e.getSalary() > 60000).map(Staff::getName).forEach(System.out::println);

        System.out.println("Get the total number of staff in the Finance department");
        Long employeeInFinance = staffList.stream().filter(e -> e.getDepartment().equals("Finance")).count();
        System.out.println(employeeInFinance);

        System.out.println("Create a list of all unique skills across staff");
        List<String> uniqueSkills = staffList.stream().flatMap(e -> e.getProjects().stream()).distinct().collect(Collectors.toList());
        System.out.println(uniqueSkills);

        System.out.println("Concatenate all staff emails into a single comma-separated string.");
        String allEmployeeEmails = staffList.stream().map(Staff::getEmail).collect(Collectors.joining(","));
        System.out.println(allEmployeeEmails);

        System.out.println("Group staff by department and count how many are in each");
        Map<String, Long> count = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartment, Collectors.counting()));
        System.out.println(count);
    }
}

