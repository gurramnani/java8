package com.demo.exam;

import com.demo.model.java8.Employee;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeTopN {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", "Female", 60000, LocalDate.of(2021, 5, 10), 28, "Bangalore", "alice@gmail.com", true),
                new Employee(2, "Bob", "HR", "Male", 35000, LocalDate.of(2019, 3, 14), 35, "Delhi", "bob@yahoo.com", true),
                new Employee(3, "Charlie", "Finance", "Male", 75000, LocalDate.of(2022, 7, 1), 42, "Mumbai", "charlie@gmail.com", false),
                new Employee(4, "Diana", "IT", "Female", 28000, LocalDate.of(2018, 11, 30), 25, "Hyderabad", "diana@gmail.com", true),
                new Employee(5, "Eve", "Admin", "Female", 50000, LocalDate.of(2020, 1, 5), 30, "Chennai", "eve@gmail.com", false)
        );

        System.out.println("Find top 2 highest paid employees by dep");
        employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        list->list.stream().
                                sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).
                                limit(2).toList()))).forEach((dep,emps)-> System.out.println(dep+":"+emps));

        System.out.println("2nd highest salary employee by dep");
        employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        list->list.stream().
                                sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst()))).
                forEach((dep,emp)-> System.out.println(dep+":"+emp));


        System.out.println("Find Top 3 Highest Paid Employees (Overall)");
        List<Employee> topThreePaidEmps = employees.stream().
                sorted(Comparator.comparingDouble(Employee::getSalary).
                        reversed()).limit(3).collect(Collectors.toList());

        System.out.println("Find Department With Maximum Total Salary");
       Map<String,Double> dep =  employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingDouble(Employee::getSalary)));
       dep.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(System.out::println);

        System.out.println("Find Duplicate Emails");
        Map<String,Long> dupEmailsCount = employees.stream().collect(
                Collectors.groupingBy(Employee::getEmail,Collectors.counting()));

       List<String> dupEmails=  dupEmailsCount.entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).toList();


        System.out.println("Find Employees Joined in Last 2 Years");
       List<Employee> empJoineBeforeTwoYears =  employees.stream().
               filter(emp-> emp.getJoiningDate()
                       .isAfter(LocalDate.now().minusYears(2)))
               .collect(Collectors.toList());

        System.out.println("Department → Average Salary (Sorted Descending)");
       LinkedHashMap<String,Double> avgSalarytSorted = employees.stream().collect(Collectors.groupingBy(
               Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary))).
               entrySet().stream().sorted(Map.Entry.<String,Double>comparingByValue().reversed()).collect(
                       Collectors.toMap(Map.Entry::getKey,
                               Map.Entry::getValue,
                               (a,b)->a,
                               LinkedHashMap::new)
               );

        System.out.println("First Non repeated character");
        String s = "aabccdbe";
      s.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(
                Function.identity(),LinkedHashMap::new,Collectors.counting())).
              entrySet().stream().filter(e->e.getValue()==1).
              map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);

        System.out.println("Flatten List of Strings to Characters");
        List<String> list = List.of("Java", "Stream");
        list.stream().flatMap(e->e.chars().mapToObj(c->(char)c)).forEach(System.out::println);

        System.out.println("Count Employees by City and Sort by Count Desc");
        Map<String,Long> countByDesemployees = employees.stream().collect(Collectors.groupingBy(
                Employee::getCity,Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a,b)->a,
                        LinkedHashMap::new)
                );

        System.out.println("Find Highest Paid Employee in Each Department (Return Name Only)");
        Map<String,String> highEmpByDepNameAndNameemp = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),Optional::orElseThrow))).
                entrySet().stream().collect(Collectors.toMap(
                        Map.Entry::getKey,
            e->e.getValue().getName(),
                    (a,b)->a,
            HashMap::new
            ));

        System.out.println("Find Second Lowest Salary Employee (Overall)");
        Optional<Employee> secLowSalary = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(1).findFirst();
    }
}