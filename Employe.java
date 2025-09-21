package com.demo.model.java8;

import java.util.*;

class Staff {

    private String name;
    private String email;
    private List<String> projects;
    private double salary;
    private String department;
    private boolean active;

    public Staff(String name, String email, List<String> projects, double salary, String department, boolean active) {
        this.name = name;
        this.email = email;
        this.projects = projects;
        this.salary = salary;
        this.department = department;
        this.active = active;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<String> getProjects() { return projects; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public boolean isActive() { return active; }

    @Override
    public String toString() {
        return name + " (" + department + ", " + salary + ")";
    }
}

