package com.example.TechPSpringBoot.employee;

import com.example.TechPSpringBoot.model.Employee;
import java.util.UUID;

public interface EmployeeDirectory {
    Employee getEmployeeById(UUID id);
    Employee[] getAllEmployees();
    Employee[] getAllEmployeesByDept(String dept);
    Employee[] getAllEmployeesByCity(String city);
}
