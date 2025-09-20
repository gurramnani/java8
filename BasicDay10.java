package com.demo.model.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BasicDay10 {
    public static void main(String[] args) {

        List<Staff> staffList = Arrays.asList(
                new Staff("Alice Johnson", "alice@mail.com", Arrays.asList("BankingApp", "Ecommerce"), 60000, "Finance", true),
                new Staff("Bob Smith", "bob@mail.com", Arrays.asList("BankingApp", "Insurance"), 75000, "IT", false),
                new Staff("Charlie Brown", "charlie@mail.com", Arrays.asList("Healthcare", "Ecommerce"), 50000, "HR", true)
        );
        
        System.out.println("Flatten staff projects");
        Set<String> flattenProjects = staffList.stream().flatMap(e->e.getProjects().stream()).collect(Collectors.toSet());
        System.out.println(flattenProjects);

        System.out.println("Count distinct project names");
        long totalProjects = staffList.stream().flatMap(s->s.getProjects().stream()).count();
        System.out.println(totalProjects);

        System.out.println("Staff working on BankingApp");
        List<Staff> workingOnBankingApp = staffList.stream().filter(s->s.getProjects().contains("BankingApp")).collect(Collectors.toList());
        workingOnBankingApp.forEach(e-> System.out.println(e.getName()));

        System.out.println("Flatten staff emails into characters");
        List<Character> chars = staffList.stream().map(Staff::getEmail).flatMap(e->e.chars().mapToObj(c->(char)c)).collect(Collectors.toList());
        System.out.println(chars);
    }
}

