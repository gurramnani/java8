package com.demo.model.java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Mian {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", "Female", 60000, LocalDate.of(2021, 5, 10), 28, "Bangalore", "alice@gmail.com", true),
                new Employee(2, "Bob", "HR", "Male", 35000, LocalDate.of(2019, 3, 14), 35, "Delhi", "bob@yahoo.com", true),
                new Employee(3, "Charlie", "Finance", "Male", 75000, LocalDate.of(2022, 7, 1), 42, "Mumbai", "charlie@gmail.com", false),
                new Employee(4, "Diana", "IT", "Female", 28000, LocalDate.of(2018, 11, 30), 25, "Hyderabad", "diana@gmail.com", true),
                new Employee(5, "Eve", "Admin", "Female", 50000, LocalDate.of(2020, 1, 5), 30, "Chennai", "eve@gmail.com", false)
        );

        System.out.println("Find all employees with salary > 50,000");
        employees.stream().filter(e->e.getSalary()>50000).forEach(System.out::println);

        System.out.println("Find employees from a given city (e.g., \"Delhi\")");
        employees.stream().filter(c-> c.getCity().equalsIgnoreCase("Delhi")).forEach(System.out::println);

        System.out.println("Get all active employees");
        employees.stream().filter(Employee::isActive).forEach(System.out::println);

        System.out.println("Find employees older than 30");
        employees.stream().filter(e->e.getAge() > 30).forEach(System.out::println);

        System.out.println("Find employees who joined after 2020");
        employees.stream().filter(d->d.getJoiningDate().isAfter(LocalDate.of(2022,8,11))).forEach(System.out::println);

        System.out.println("List employees whose name starts with \"A\"");
        employees.stream().filter(s->s.getName().startsWith("A")).forEach(System.out::println);

        System.out.println("Get female employees only");
        employees.stream().filter(f->f.getGender().equalsIgnoreCase("Female")).forEach(System.out::println);

        System.out.println("Find employees who are not active");
        employees.stream().filter(n->!n.isActive()).forEach(System.out::println);

        System.out.println("Get employees working in \"IT\" department");
        employees.stream().filter(i->i.getDepartment().equalsIgnoreCase("IT")).forEach(System.out::println);

        System.out.println("Get employees with salary < 30,000");
        employees.stream().filter(ls->ls.getSalary()<30000).forEach(System.out::println);
    }
}
