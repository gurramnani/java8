package com.demo.exam;

import com.demo.model.java8.Staff;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
    }
}
