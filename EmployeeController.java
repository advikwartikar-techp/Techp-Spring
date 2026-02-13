package com.example.TechPSpringBoot.controller;

import com.example.TechPSpringBoot.employee.EmployeeStoreUsingArrayList;
import com.example.TechPSpringBoot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeStoreUsingArrayList store;

    @Autowired
    public EmployeeController(EmployeeStoreUsingArrayList store) {
        this.store = store;
    }

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        // generate id if missing
        if (employee.getId() == null) {
            employee.setId(UUID.randomUUID());
        }
        store.add(employee);
        return ResponseEntity.ok("Employee added successfully");
    }

    @GetMapping
    public Employee[] getAllEmployees() {
        return store.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id) {
        try {
            UUID uuid = UUID.fromString(id);
            Employee e = store.getEmployeeById(uuid);
            if (e == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(e);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
