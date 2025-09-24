package com.demo.exam;

import com.demo.model.java8.Staff;

import java.util.*;
import java.util.stream.Collectors;

public class EnhanceOne {
    public static void main(String[] args) {

        List<Staff> staffList = Arrays.asList(
                new Staff("Alice Johnson", "alice@mail.com", Arrays.asList("BankingApp", "Ecommerce"), 60000, "Finance", true),
                new Staff("Bob Smith", "bob@mail.com", Arrays.asList("BankingApp", "Insurance"), 75000, "IT", false),
                new Staff("Charlie Brown", "charlie@mail.com", Arrays.asList("Healthcare", "Ecommerce"), 50000, "HR", true)
        );
        System.out.println("Partition staff into two groups: salary > 50,000 and ≤ 50,000. (partitioningBy)");
        Map<Boolean,List<Staff>> partitionStaff = staffList.stream().collect(Collectors.partitioningBy(e->e.getSalary() >50000));
        partitionStaff.forEach((k,v)-> System.out.println(k+":"+v));

        System.out.println("Get the total salary of all staff using");
        staffList.stream().mapToDouble(Staff::getSalary).reduce((a,b)->a+b).ifPresentOrElse((a)->System.out.println(a),()-> System.out.println("No salary is present"));

        System.out.println("Find distinct first letters of all staff names. (map + distinct)");
        staffList.stream().map(Staff::getName).map(s->s.substring(0,1)).distinct().forEach(System.out::println);

        System.out.println("Sort staff by name in reverse order and collect names into a list.");
        List<String> reverseOrderNames =  staffList.stream().map(Staff::getName).sorted(Comparator.comparing(String::valueOf).reversed()).collect(Collectors.toList());
        System.out.println(reverseOrderNames);

        System.out.println("Find the staff with the longest name");
        staffList.stream().max(Comparator.comparing(s->s.getName().length())).ifPresent(System.out::println);
        staffList.stream().map(Staff::getName).forEach(s-> System.out.println(s.length()+":"+s));

        System.out.println("Return optional staff whose email ends with @mail.com ");
        Optional<Staff> endsWithEmail = staffList.stream().filter(s->s.getEmail().endsWith("@mail.com")).findFirst();
        System.out.println(endsWithEmail);

        System.out.println("Find department-wise highest salary staff");
        Map<String,Optional<Staff>> highestSalaryByDepartment = staffList.stream().collect(Collectors.groupingBy(Staff::getDepartment,Collectors.maxBy(Comparator.comparing(Staff::getSalary))));
        System.out.println(highestSalaryByDepartment);
    }
}
