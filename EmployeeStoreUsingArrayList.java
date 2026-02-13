package com.example.TechPSpringBoot.employee;

import com.example.TechPSpringBoot.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeStoreUsingArrayList implements EmployeeDirectory {
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeStoreUsingArrayList() {}

    public void add(Employee e) {
        employees.add(e);
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Employee[] getAllEmployees() {
        return employees.toArray(new Employee[0]);
    }

    @Override
    public Employee[] getAllEmployeesByDept(String dept) {
        // No dept field on Employee yet; return empty for now
        List<Employee> filtered = employees.stream().collect(Collectors.toList());
        return filtered.toArray(new Employee[0]);
    }

    @Override
    public Employee[] getAllEmployeesByCity(String city) {
        // No city field on Employee yet; return all for now
        return getAllEmployees();
    }
}
