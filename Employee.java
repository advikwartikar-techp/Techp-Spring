package com.example.TechPSpringBoot.model;

import java.time.LocalDate;
import java.util.UUID;

public class Employee {
    private UUID id;
    private String name;
    private float salary;
    private LocalDate dob;
    public Employee() {
    }

    public Employee(UUID id, String name, float salary, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dob = dob;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
