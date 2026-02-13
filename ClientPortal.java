package com.example.TechPSpringBoot.employee;

import com.example.TechPSpringBoot.model.Employee;

import java.time.LocalDate;
import java.util.UUID;

public class ClientPortal {
    public static void main(String[] args) {
        EmployeeStoreUsingArrayList store = new EmployeeStoreUsingArrayList();
        EmployeeServiceV1 service = new EmployeeServiceV1(store);

        Employee e1 = new Employee(UUID.randomUUID(), "Alice", 75000f, LocalDate.of(1990, 5, 20));
        Employee e2 = new Employee(UUID.randomUUID(), "Bob", 65000f, LocalDate.of(1988, 8, 15));
        Employee e3 = new Employee(UUID.randomUUID(), "Charlie", 82000f, LocalDate.of(1985, 3, 10));

        store.add(e1);
        store.add(e2);
        store.add(e3);

        System.out.println("All employees:");
        for (Employee e: service.getAllEmployees()) {
            System.out.println(e.getName() + " (" + e.getId() + ") - salary=" + e.getSalary());
        }
    }
}
