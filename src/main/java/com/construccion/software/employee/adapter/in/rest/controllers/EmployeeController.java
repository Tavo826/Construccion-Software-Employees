package com.construccion.software.employee.adapter.in.rest.controllers;

import com.construccion.software.employee.adapter.in.builder.EmployeeBuilder;
import com.construccion.software.employee.adapter.in.rest.request.EmployeeRequest;
import com.construccion.software.employee.application.usecases.EmployeeUseCase;
import com.construccion.software.employee.domain.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private final EmployeeBuilder employeeBuilder;
    private final EmployeeUseCase employeeUseCase;

    public EmployeeController(EmployeeBuilder employeeBuilder, EmployeeUseCase employeeUseCase) {
        this.employeeBuilder = employeeBuilder;
        this.employeeUseCase = employeeUseCase;
    }

    @GetMapping("/Employees/{documentId}")
    public ResponseEntity<?> getEmployeeByDocumentId(@PathVariable String documentId) throws Exception {

        Employee employee = employeeUseCase.getEmployeeByDocumentId(employeeBuilder.getDocumentId(documentId));

        return ResponseEntity.ok(employee);

    }

    @PostMapping("/Employees")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest request) throws Exception {

        Employee employee = employeeBuilder.build(
                request.getDocumentId(),
                request.getName(),
                request.getBirthDate(),
                request.getPhone(),
                request.getEmail(),
                request.getAddress(),
                request.getRole(),
                request.getUsername(),
                request.getPassword()
        );

        Employee createdEmployee = employeeUseCase.createEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdEmployee);
    }

    @PatchMapping("/Employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable long id, @RequestBody EmployeeRequest request) throws Exception {

        Employee employee = employeeBuilder.build(
                request.getDocumentId(),
                request.getName(),
                request.getBirthDate(),
                request.getPhone(),
                request.getEmail(),
                request.getAddress(),
                request.getRole(),
                request.getUsername(),
                request.getPassword()
        );

        Employee updatedEmployee = employeeUseCase.updateEmployee(id, employee);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("Employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id) throws Exception {

        employeeUseCase.deleteEmployee(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
