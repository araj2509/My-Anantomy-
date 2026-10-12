package com.example.employeeapi;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public List<Employee> getEmployees() {
        return List.of(
            new Employee("Asha Sharma", "asha@example.com", 28),
            new Employee("Rahul Verma", "rahul@example.com", 32)
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        // Learning example: echoes the validated employee back; nothing is stored.
        return employee;
    }
}
